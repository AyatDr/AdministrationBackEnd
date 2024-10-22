package ma.ensa.GestionCours.controller.DIRECTEURCONTROLLER;
import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.FormationService;
import ma.ensa.GestionCours.Model.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/")
public class DirecteurController {

    @Autowired
    private  FormationService formationService;

    @GetMapping("/formation/list")
    public List<Formation> getAllFormations() {
        return formationService.getAllFormations();
    }
}
