package ma.ensa.GestionCours.controller.ProfesseurController;
import ma.ensa.GestionCours.DAO.DAO_PROFESSEUR.ProfFormation;
import ma.ensa.GestionCours.Model.Formation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController 
@RequestMapping("/api/")
public class ProfesseurController {

    @Autowired
    private ProfFormation profFormation;

    @GetMapping("/prof/formations/{id}/list")
    public Set<Formation> getAllFormations(@PathVariable Integer id) {
        return profFormation.getFormationsForAuthenticatedProfesseur(id);
    }
}
