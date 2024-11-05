package ma.ensa.GestionCours.Service.prof;

import ma.ensa.GestionCours.DAO.DAO_PROFESSEUR.*;

import ma.ensa.GestionCours.DTO.DTO_PROFESSEUR.*;
import ma.ensa.GestionCours.Model.*;
import ma.ensa.GestionCours.Model.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
// Cette classe contiendra tous les services du professeur
// implementer l interface pour rendre l application extensible
public class ServiceProfImpl implements IServiceProf {

    @Autowired
    private ProfesseurRepository professeurRepository;

    @Autowired
    private MatiereRepository matiereRepository;

    @Autowired
    private ModuleRepository moduleRepository;

    @Autowired
    private SemestreRepository semestreRepository;

    @Autowired
    private FormationRepository formationRepository;

    @Autowired
    private CoursRepository coursRepository;

    @Autowired
    private LienRepository lienRepository;

    @Autowired
    private DocumentRepository documentRepository;

    @Autowired
    private NoteRepository noteRepository;

    private final String uploadDir = "uploads/";

    private static final Logger loggand  = LoggerFactory.getLogger(ServiceProfImpl.class);

    public Set<Formation> getFormationsForAuthenticatedProfesseur(Integer id) {

        Prof professeur = professeurRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Professeur not found"));

        if (professeur == null) {
            throw new RuntimeException("Authenticated professeur not found.");
        }

        List<Matiere> matieres = matiereRepository.findByProfesseur(professeur);

        return matieres.stream()
                .map(Matiere::getModule)
                .map(Module::getSemestre)
                .map(Semestre::getFormation)
                .collect(Collectors.toSet());
    }

    public Set<Semestre> getSemestresForFormation(Integer id1, Integer id2) {
        System.out.println("prif"+id1+"form"+id2);
        Prof professeur = professeurRepository.findById(id1).orElseThrow(() -> new IllegalArgumentException("Professeur not found"));

        if (professeur == null) {
            throw new RuntimeException("Authenticated professeur not found.");
        }

        List<Matiere> matieres = matiereRepository.findByProfesseur(professeur);

        return matieres.stream()
                .map(Matiere::getModule)            // Récupère le module de chaque matière
                .map(Module::getSemestre)           // Récupère le semestre associé à chaque module
                .filter(semestre -> semestre.getFormation() != null &&
                        semestre.getFormation().getId() == id2)  // Filtrer les semestres dont la formation a un id égal à id2
                .collect(Collectors.toSet());
    }

    public Map<String, Object> getModulesForSemestre(Integer id) {

        Semestre semestre = semestreRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Semestre not found"));

        if (semestre == null) {
            throw new RuntimeException("Semestre not found.");
        }

        List<Module> modules = moduleRepository.findBySemestre(semestre);

        Map<String, Object> response = new HashMap<>();
        response.put("label", semestre.getLabel());
        response.put("modules", modules);

        return response;
    }

    public Map<String, Object> getMatieresForModule(Integer id) {

        Module module = moduleRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Module not found"));

        if (module == null) {
            throw new RuntimeException("Module not found.");
        }

        List<Matiere> matieres = matiereRepository.findByModule(module);

        Map<String, Object> response = new HashMap<>();
        response.put("label", module.getLabel());
        response.put("matieres", matieres);

        return response;
    }

    public Map<String, Object> getCoursForMatiere(Integer id) {

        Matiere matiere = matiereRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Matiere not found"));

        if (matiere == null) {
            throw new RuntimeException("Matiere not found.");
        }

        List<Cours> cours = coursRepository.findByMatiere(matiere);

        Map<String, Object> response = new HashMap<>();
        response.put("label", matiere.getLabel());
        response.put("cours", cours);

        return response;
    }

    public Cours createCours(CoursDTO coursDTO) {

        Matiere matiere = matiereRepository.findById(coursDTO.getMatiereId())
                .orElseThrow(() -> new IllegalArgumentException("Matiere not found"));

        Cours cours = new Cours();
        cours.setLabel(coursDTO.getLabel());
        cours.setMatiere(matiere);

        return coursRepository.save(cours);
    }

    public Cours getCours(Integer id) {

        return coursRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Cours not found"));
    }

    public Cours updateCoursLabel(CoursUpdateDTO coursUpdateDTO) {

        Cours cours = coursRepository.findById(coursUpdateDTO.getId())
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        cours.setLabel(coursUpdateDTO.getLabel());

        return coursRepository.save(cours);
    }

    public void deleteCoursById(Integer id) {

        if (!coursRepository.existsById(id)) {
            throw new IllegalArgumentException("Course not found with ID: " + id);
        }

        coursRepository.deleteById(id);
    }

    public CourseResourcesDTO getCourseResources(Integer coursId) {

        Cours cours = coursRepository.findById(coursId)
                .orElseThrow(() -> new RuntimeException("Course not found with id: " + coursId));

        List<LienDTO> lienDTOs = lienRepository.findByCours(cours)
                .stream()
                .map(lien -> new LienDTO(lien.getId(), lien.getLabel(), lien.getUrlLien()))
                .collect(Collectors.toList());

        List<DocumentDTO> documentDTOs = documentRepository.findByCours(cours)
                .stream()
                .map(document -> new DocumentDTO(document.getId(), document.getLabel(), document.getUrlDoc()))
                .collect(Collectors.toList());

        return new CourseResourcesDTO(cours.getId(), cours.getLabel(), lienDTOs, documentDTOs);
    }

    public Lien createLien(String label, String urlLien, Integer coursId) {

        Cours cours = coursRepository.findById(coursId)
                .orElseThrow(() -> new IllegalArgumentException("Course not found"));

        Lien lien = new Lien();
        lien.setLabel(label);
        lien.setUrlLien(urlLien);
        lien.setCours(cours);

        return lienRepository.save(lien);
    }

    public void deleteLienById(Integer id) {

        if (!lienRepository.existsById(id)) {
            throw new IllegalArgumentException("Lien not found with ID: " + id);
        }

        lienRepository.deleteById(id);
    }

    public Document createDocument(CreateDocumentDTO dto) throws IOException {

        Cours cours = coursRepository.findById(dto.getCoursId())
                .orElseThrow(() -> new IllegalArgumentException("Cours not found"));

        String fileName = storeFile(dto.getDocument());

        Document document = new Document();
        document.setLabel(dto.getLabel());
        document.setUrlDoc(uploadDir + fileName);
        document.setCours(cours);

        return documentRepository.save(document);
    }

    private String storeFile(MultipartFile file) throws IOException {

        String fileName = file.getOriginalFilename();

        Path path = Paths.get(uploadDir + fileName);

        Files.createDirectories(path.getParent());

        Files.copy(file.getInputStream(), path, StandardCopyOption.REPLACE_EXISTING);

        return fileName;
    }

    public void deleteDocumentById(Integer id) throws IOException {

        Document document = documentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Document not found with ID: " + id));

        String filePath = document.getUrlDoc();

        Path path = Paths.get(filePath);
        if (Files.exists(path)) {
            Files.delete(path);
        }

        documentRepository.deleteById(id);
    }

    public MatiereWithNotesDTO getNotesByMatiereId(Integer matiereId) {

        Matiere matiere = matiereRepository.findById(matiereId)
                .orElseThrow(() -> new IllegalArgumentException("Matiere not found with ID: " + matiereId));

        List<Note> notes = noteRepository.findByMatiere(matiere);

        List<NoteDTO> noteDTOs = notes.stream()
                .map(note -> new NoteDTO(note.getId(), note.getEtudiant().getNom() + " " + note.getEtudiant().getPrenom(), note.getValeur()))
                .collect(Collectors.toList());

        return new MatiereWithNotesDTO(matiere.getId(), matiere.getLabel(), noteDTOs);
    }

    public Note updateNote(Integer noteId, float newValue) {

        Note note = noteRepository.findById(noteId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Note not found with id: " + noteId));

        note.setValeur(newValue);
        return noteRepository.save(note);
    }

}
