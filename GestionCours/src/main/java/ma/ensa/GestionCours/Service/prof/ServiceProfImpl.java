package ma.ensa.GestionCours.Service.prof;

import ma.ensa.GestionCours.DAO.DAO_PROFESSEUR.*;

import ma.ensa.GestionCours.Model.*;
import ma.ensa.GestionCours.Model.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.web.multipart.MultipartFile;

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

    private final String uploadDir = "uploads/";

    private static final Logger logger = LoggerFactory.getLogger(ServiceProfImpl.class);

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

    public Map<String, Object> getSemestresForFormation(Integer id) {

        Formation formation = formationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Formation not found"));

        if (formation == null) {
            throw new RuntimeException("Formation not found.");
        }

        List<Semestre> semestres = semestreRepository.findByFormation(formation);

        Map<String, Object> response = new HashMap<>();
        response.put("label", formation.getLabel());
        response.put("semestres", semestres);

        return response;
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

}
