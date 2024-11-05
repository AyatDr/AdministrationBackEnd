package ma.ensa.GestionCours.controller.ProfesseurController;
import ma.ensa.GestionCours.DTO.DTO_PROFESSEUR.*;
import ma.ensa.GestionCours.Model.*;
import ma.ensa.GestionCours.Service.prof.IServiceProf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/api/")
public class ProfesseurController {

    private IServiceProf serviceProf;
    @Autowired
    public ProfesseurController(IServiceProf serviceProf) { this.serviceProf= serviceProf;}

    @GetMapping("/prof/formations/{id}/list")
    public Set<Formation> getAllFormations(@PathVariable Integer id) {
        return serviceProf.getFormationsForAuthenticatedProfesseur(id);
    }

    @GetMapping("/prof/formation/{id1}/{id2}/semestres/list")
    public  Set<Semestre> getSemestresOfFormation(@PathVariable Integer id1 , @PathVariable Integer id2) {
        return serviceProf.getSemestresForFormation(id1,id2);
    }

    @GetMapping("/prof/semestre/{id}/modules/list")
    public Map<String, Object> getModulesForSemestre(@PathVariable Integer id) {
        return serviceProf.getModulesForSemestre(id);
    }

    @GetMapping("/prof/module/{id}/matieres/list")
    public Map<String, Object> getMatieresForModule(@PathVariable Integer id) {
        return serviceProf.getMatieresForModule(id);
    }

    @GetMapping("/prof/matiere/{id}/cours/list")
    public Map<String, Object> getCoursForMatiere(@PathVariable Integer id) {
        return serviceProf.getCoursForMatiere(id);
    }

    @PostMapping("/cours/create")
    public ResponseEntity<Cours> createCourse(@RequestBody CoursDTO coursDTO) {
        Cours createdCours = serviceProf.createCours(coursDTO);
        return ResponseEntity.ok(createdCours);
    }

    @GetMapping("/cours/{id}/get")
    public ResponseEntity<Cours> getCours(@PathVariable Integer id) {
        Cours cours = serviceProf.getCours(id);
        return ResponseEntity.ok(cours);
    }

    @PutMapping("/cours/update")
    public ResponseEntity<Cours> updateCourseLabel(@RequestBody CoursUpdateDTO coursUpdateDTO) {
        Cours updatedCours = serviceProf.updateCoursLabel(coursUpdateDTO);
        return ResponseEntity.ok(updatedCours);
    }

    @DeleteMapping("/cours/{id}/delete")
    public ResponseEntity<Void> deleteCourse(@PathVariable Integer id) {
        serviceProf.deleteCoursById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/cours/{id}/resources")
    public ResponseEntity<CourseResourcesDTO> getCourseResources(@PathVariable Integer id) {
        CourseResourcesDTO courseResources = serviceProf.getCourseResources(id);
        return ResponseEntity.ok(courseResources);
    }

    @PostMapping("/lien/create")
    public ResponseEntity<Lien> createLien(@RequestBody CreateLienDTO createLienDTO) {

        Lien createdLien = serviceProf.createLien(
                createLienDTO.getLabel(),
                createLienDTO.getUrlLien(),
                createLienDTO.getCoursId()
        );

        return ResponseEntity.ok(createdLien);
    }

    @DeleteMapping("/lien/{id}/delete")
    public ResponseEntity<Void> deleteLien(@PathVariable Integer id) {
        serviceProf.deleteLienById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/document/create")
    public ResponseEntity<?> createDocument(@ModelAttribute CreateDocumentDTO dto) {
        try {
            Document document = serviceProf.createDocument(dto);
            return ResponseEntity.ok(document);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/document/{id}/delete")
    public ResponseEntity<Void> deleteDocumentById(@PathVariable Integer id) throws IOException {
        serviceProf.deleteDocumentById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/matiere/{matiereId}/notes")
    public MatiereWithNotesDTO getNotesByMatiere(@PathVariable Integer matiereId) {
        return serviceProf.getNotesByMatiereId(matiereId);
    }

    @PutMapping("/note/{noteId}/update")
    public ResponseEntity<Note> updateNote(@PathVariable Integer noteId, @RequestBody UpdateNoteDTO request) {
        Note updatedNote = serviceProf.updateNote(noteId, request.getValeur());
        return ResponseEntity.ok(updatedNote);
    }

}
