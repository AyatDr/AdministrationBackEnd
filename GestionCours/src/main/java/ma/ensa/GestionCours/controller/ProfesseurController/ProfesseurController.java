package ma.ensa.GestionCours.controller.ProfesseurController;
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

    @GetMapping("/prof/formation/{id}/semestres/list")
    public Map<String, Object> getSemestresOfFormation(@PathVariable Integer id) {
        return serviceProf.getSemestresForFormation(id);
    }

    @GetMapping("/prof/semestre/{id}/modules/list")
    public Map<String, Object> getModulesForSemestre(@PathVariable Integer id) {
        return serviceProf.getModulesForSemestre(id);
    }

    @GetMapping("/prof/module/{id}/matieres/list")
    public Map<String, Object> getMatieresForModule(@PathVariable Integer id) {
        return serviceProf.getMatieresForModule(id);
    }

}
