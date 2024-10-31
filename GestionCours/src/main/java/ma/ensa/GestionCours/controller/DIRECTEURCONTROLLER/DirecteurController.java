package ma.ensa.GestionCours.controller.DIRECTEURCONTROLLER;
import ma.ensa.GestionCours.DTO.DTO_DIRECTEUR.*;
import ma.ensa.GestionCours.Model.*;
import ma.ensa.GestionCours.Model.Module;
import ma.ensa.GestionCours.Service.ServiceDirecteur.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping("/api/")
public class DirecteurController {

    @Autowired
    private IServiceFormation formationService;
    @Autowired
    private IServiceEnsegnant ensegnantService;
    @Autowired
    private IServiceEtudiant etudiantService;
    @Autowired
    private IServiceSemestre semestreService;
    @Autowired
    private IServiceModule moduleService;
    @Autowired
    private IServiceMatiere matiereService;
    @Autowired
    private IServiceProf profService;
    @Autowired
    private IServiceCours coursService;

    @GetMapping("directeur/formation/list")
    public List<Formation> getAllFormations() {
        return formationService.getAllFormations();
    }

    @GetMapping("/professeur/list")
    public List<Prof> getAllProfesseurs() {
        return ensegnantService.getAllProfesseurs();
    }

    @GetMapping("/etudiant/list")
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @PostMapping(value = "/directeur/addFormation")
    public Formation addFormation(@RequestBody FormationDTO formationDTO) {
        System.out.println("Formation reçue : " + formationDTO.getLabel() + " - " + formationDTO.getDescription());

        // Mapper le DTO vers l'entité Formation
        Formation formation = new Formation();
        formation.setLabel(formationDTO.getLabel());
        formation.setDescription(formationDTO.getDescription());

        // Sauvegarder la formation en base
        return formationService.saveFormation(formation);
    }

    @PostMapping("/directeur/addSemestre")
    public Semestre addSemestre(@RequestBody SemestreDTO semestreDTO) {
        try {
            System.out.println("Payload reçu : " + semestreDTO.toString());

            // Vérifiez si l'ID de formation est valide
            if (semestreDTO.getFormationId() == null) {
                throw new RuntimeException("L'ID de la formation est manquant.");
            }

            // Rechercher la formation associée
            Formation formation = formationService.findById(semestreDTO.getFormationId())
                    .orElseThrow(() -> new RuntimeException("Formation non trouvée avec l'ID : " + semestreDTO.getFormationId()));

            System.out.println("Formation trouvée : " + formation.getLabel());

            // Créer l'objet Semestre et définir ses champs
            Semestre semestre = new Semestre();
            semestre.setLabel(semestreDTO.getLabel());
            semestre.setDateDebut(LocalDate.parse(semestreDTO.getDateDebut()));  // Conversion en LocalDate
            semestre.setDateFin(LocalDate.parse(semestreDTO.getDateFin()));      // Conversion en LocalDate
            semestre.setFormation(formation);

            System.out.println("Semestre prêt à être sauvegardé : " + semestre);

            // Sauvegarder en base
            return semestreService.saveSemestre(semestre);

        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout du semestre : " + e.getMessage());
            throw e;  // Relever l'exception pour voir la trace complète
        }
    }

    @PostMapping("/directeur/addModule")
    public Module addModule(@RequestBody ModuleDTO moduleDTO) {
        try {
            System.out.println("Payload reçu : " + moduleDTO.toString());

            // Vérifiez si l'ID de formation est valide
            if (moduleDTO.getSemestreId() == null) {
                throw new RuntimeException("L'ID de la semstre est manquant.");
            }

            // Rechercher la formation associée
            Semestre semestre = semestreService.findById(moduleDTO.getSemestreId())
                    .orElseThrow(() -> new RuntimeException("Formation non trouvée avec l'ID : " + moduleDTO.getSemestreId()));

            System.out.println("semestre trouvée : " + semestre.getLabel());

            // Créer l'objet Semestre et définir ses champs
            Module module = new Module();
            module.setLabel(moduleDTO.getLabel());
            module.setSemestre(semestre);

            System.out.println("Module prêt à être sauvegardé : " + module);

            // Sauvegarder en base
            return moduleService.saveModule(module);

        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout du Module : " + e.getMessage());
            throw e;  // Relever l'exception pour voir la trace complète
        }
    }

    @PostMapping("/directeur/addMatiere")
    public Matiere addMatiere(@RequestBody MatiereDTO matiereDTO) {
        try {
            System.out.println("Payload reçu : " + matiereDTO.toString());

            // Vérifiez si l'ID de formation est valide
            if (matiereDTO.getModuleId() == null) {
                throw new RuntimeException("L'ID de la module est manquant.");
            }

            // Rechercher la formation associée
            Module module = moduleService.findById(matiereDTO.getModuleId())
                    .orElseThrow(() -> new RuntimeException("module non trouvée avec l'ID : " + matiereDTO.getModuleId()));
            // Rechercher la formation associée
            Prof prof = profService.findById(matiereDTO.getProfesseurId())
                    .orElseThrow(() -> new RuntimeException("prof non trouvée avec l'ID : " + matiereDTO.getProfesseurId()));

            System.out.println("semestre trouvée : " + module.getLabel());

            // Créer l'objet Semestre et définir ses champs
            Matiere matiere = new Matiere();
            matiere.setLabel(matiereDTO.getLabel());
            matiere.setDescription(matiereDTO.getDescription());
            matiere.setModule(module);
            matiere.setProfesseur(prof);

            System.out.println("Module prêt à être sauvegardé : " + module);

            // Sauvegarder en base
            return matiereService.saveMatiere(matiere);

        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout du matiere : " + e.getMessage());
            throw e;  // Relever l'exception pour voir la trace complète
        }
    }

    @PostMapping("/directeur/addCours")
    public Cours addCours(@RequestBody CoursDTO coursDTO) {
        try {
            System.out.println("Payload reçu : " + coursDTO.toString());

            // Vérifiez si l'ID de formation est valide
            if (coursDTO.getMatiereId() == null) {
                throw new RuntimeException("L'ID de la matiere est manquant.");
            }

            // Rechercher la formation associée
            Matiere matiere = matiereService.findById(coursDTO.getMatiereId())
                    .orElseThrow(() -> new RuntimeException("module non trouvée avec l'ID : " + coursDTO.getMatiereId()));


            // Créer l'objet Semestre et définir ses champs
            Cours cours = new Cours();
            cours.setLabel(coursDTO.getLabel());
            cours.setMatiere(matiere);


            System.out.println("Module prêt à être sauvegardé : " + cours);

            // Sauvegarder en base
            return coursService.saveCours(cours);

        } catch (Exception e) {
            System.err.println("Erreur lors de l'ajout du matiere : " + e.getMessage());
            throw e;  // Relever l'exception pour voir la trace complète
        }
    }


    @DeleteMapping("/directeur/deleteFormation/{id}")
    public ResponseEntity<String> deleteFormation(@PathVariable Integer id) {
        System.out.println(id);
        try {

            formationService.deleteFormation(id);  // Méthode de suppression du service
            return ResponseEntity.ok("Formation supprimée avec succès");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de la formation");
        }
    }

    @DeleteMapping("/directeur/deleteSemestre/{id}")
    public ResponseEntity<String> deleteSemestre(@PathVariable Integer id) {
        System.out.println(id);
        try {

            semestreService.deleteSemestre(id);  // Méthode de suppression du service
            return ResponseEntity.ok("Formation supprimée avec succès");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de la formation");
        }
    }

    @DeleteMapping("/directeur/deleteModule/{id}")
    public ResponseEntity<String> deleteModule(@PathVariable Integer id) {
        System.out.println(id);
        try {

            moduleService.deleteModule(id);  // Méthode de suppression du service
            return ResponseEntity.ok("Formation supprimée avec succès");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de la formation");
        }
    }

    @DeleteMapping("/directeur/deleteMatiere/{id}")
    public ResponseEntity<String> deleteMatiere(@PathVariable Integer id) {
        System.out.println(id);
        try {

            matiereService.deleteMatiere(id);  // Méthode de suppression du service
            return ResponseEntity.ok("Formation supprimée avec succès");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de la formation");
        }
    }

    @DeleteMapping("/directeur/deleteCours/{id}")
    public ResponseEntity<String> deleteCours(@PathVariable Integer id) {
        System.out.println(id);
        try {

            coursService.deleteCours(id);  // Méthode de suppression du service
            return ResponseEntity.ok("Formation supprimée avec succès");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Erreur lors de la suppression de la formation");
        }
    }


    @PutMapping(value = "/directeur/updateFormation/{id}")
    public ResponseEntity<Formation> updateFormation(
            @PathVariable Integer id,
            @RequestBody FormationDTO formationDTO) {

        System.out.println("Mise à jour de la formation ID : " + id);
        System.out.println("label de la nouvelle formation: " + formationDTO.getLabel());
        System.out.println("desc de la nouvelle formation: " + formationDTO.getDescription());

        // Rechercher la formation existante par ID
        Optional<Formation> existingFormation = formationService.findById(id);

        if (existingFormation.isPresent()) {
            Formation formation = existingFormation.get();

            // Mettre à jour les champs
            formation.setLabel(formationDTO.getLabel());
            formation.setDescription(formationDTO.getDescription());

            // Sauvegarder les modifications
            Formation updatedFormation = formationService.saveFormation(formation);

            return ResponseEntity.ok(updatedFormation);
        } else {
            // Retourner une réponse 404 si la formation n'existe pas
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/directeur/updateSemestre/{id}")
    public ResponseEntity<Semestre> updateSemestre(
            @PathVariable Integer id,
            @RequestBody SemestreDTO semestreDTO) {
        try {
            System.out.println("Mise à jour du semestre avec ID : " + id);

            // Vérifiez si le semestre existe
            Semestre existingSemestre = semestreService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Semestre non trouvé avec l'ID : " + id));

            System.out.println("Semestre existant trouvé : " + existingSemestre);

            // Mettre à jour les champs du semestre sans changer la formation associée
            existingSemestre.setLabel(semestreDTO.getLabel());
            existingSemestre.setDateDebut(LocalDate.parse(semestreDTO.getDateDebut()));
            existingSemestre.setDateFin(LocalDate.parse(semestreDTO.getDateFin()));

            System.out.println("Semestre mis à jour prêt à être sauvegardé : " + existingSemestre);

            // Sauvegarder les modifications
            Semestre updatedSemestre = semestreService.saveSemestre(existingSemestre);

            return ResponseEntity.ok(updatedSemestre);

        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour du semestre : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PutMapping("/directeur/updateModule/{id}")
    public ResponseEntity<Module> updateModule(
            @PathVariable Integer id,
            @RequestBody ModuleDTO moduleDTO) {
        try {
            System.out.println("Mise à jour du module avec ID : " + id);

            // Vérifier si le module existe
            Module existingModule = moduleService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Module non trouvé avec l'ID : " + id));

            System.out.println("Module existant trouvé : " + existingModule);

            // Mettre à jour le label du module sans changer le semestre
            existingModule.setLabel(moduleDTO.getLabel());

            System.out.println("Module mis à jour prêt à être sauvegardé : " + existingModule);

            // Sauvegarder les modifications
            Module updatedModule = moduleService.saveModule(existingModule);

            return ResponseEntity.ok(updatedModule);

        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour du module : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @PutMapping("/directeur/updateMatiere/{id}")
    public ResponseEntity<Matiere> updateMatiere(
            @PathVariable Integer id,
            @RequestBody MatiereDTO matiereDTO) {
        try {
            System.out.println("Mise à jour de la matière avec ID : " + id);

            // Vérifier si la matière existe
            Matiere existingMatiere = matiereService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Matière non trouvée avec l'ID : " + id));

            System.out.println("Matière existante trouvée : " + existingMatiere);

            // Mettre à jour le label et la description de la matière
            existingMatiere.setLabel(matiereDTO.getLabel());
            existingMatiere.setDescription(matiereDTO.getDescription());

            // Rechercher le professeur associé si nécessaire
            if (matiereDTO.getProfesseurId() != null) {
                Prof prof = profService.findById(matiereDTO.getProfesseurId())
                        .orElseThrow(() -> new RuntimeException("Professeur non trouvé avec l'ID : " + matiereDTO.getProfesseurId()));
                existingMatiere.setProfesseur(prof);
            }

            System.out.println("Matière mise à jour : " + existingMatiere);

            // Sauvegarder les modifications
            Matiere updatedMatiere = matiereService.saveMatiere(existingMatiere);

            return ResponseEntity.ok(updatedMatiere);

        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour de la matière : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }



    @PutMapping("/directeur/updateCours/{id}")
    public ResponseEntity<Cours> updateCours(
            @PathVariable Integer id,
            @RequestBody CoursDTO coursDTO) {
        try {
            System.out.println("Mise à jour du cours avec ID : " + id);

            // Vérifier si le cours existe
            Cours existingCours = coursService.findById(id)
                    .orElseThrow(() -> new RuntimeException("Cours non trouvé avec l'ID : " + id));

            System.out.println("Cours existant trouvé : " + existingCours);

            // Mettre à jour le label du cours
            existingCours.setLabel(coursDTO.getLabel());

            System.out.println("Cours mis à jour : " + existingCours);

            // Sauvegarder les modifications
            Cours updatedCours = coursService.saveCours(existingCours);

            return ResponseEntity.ok(updatedCours);

        } catch (Exception e) {
            System.err.println("Erreur lors de la mise à jour du cours : " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @GetMapping("/formationEtudiant/{id}")
    public Formation getFormationEtudiant(@PathVariable Integer id) {
        return formationService.getFormationEtudiant(id);
    }

    @GetMapping("/SemestreByEtudiant/{id}")
    public Semestre getSemestreByEtudiant(@PathVariable Integer id) {
        return etudiantService.getSemestreByEtudiant(id);
    }


    @GetMapping("/etudiant/{etudiantId}/matiere/{matiereId}")
    public float getNoteEtudiantByMatiere(@PathVariable Integer etudiantId ,@PathVariable Integer matiereId) {
        return etudiantService.getNoteEtudiantByMatiere(etudiantId ,matiereId );
    }





}
