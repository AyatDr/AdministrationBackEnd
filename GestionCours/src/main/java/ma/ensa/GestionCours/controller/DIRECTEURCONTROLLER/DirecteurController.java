package ma.ensa.GestionCours.controller.DIRECTEURCONTROLLER;
import ma.ensa.GestionCours.Model.Etudiant;
import ma.ensa.GestionCours.Model.Formation;
import ma.ensa.GestionCours.Model.Prof;
import ma.ensa.GestionCours.Service.ServiceDirecteur.FormationService;
import ma.ensa.GestionCours.Service.ServiceDirecteur.IServiceEnsegnant;
import ma.ensa.GestionCours.Service.ServiceDirecteur.IServiceEtudiant;
import ma.ensa.GestionCours.Service.ServiceDirecteur.IServiceFormation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class DirecteurController {

    @Autowired
    private IServiceFormation formationService;
    @Autowired
    private IServiceEnsegnant ensegnantService;
    @Autowired
    private IServiceEtudiant etudiantService;

    @GetMapping("/formation/list")
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
}
