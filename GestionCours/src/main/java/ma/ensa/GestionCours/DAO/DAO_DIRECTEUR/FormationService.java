package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;
import ma.ensa.GestionCours.Model.Formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService {

    @Autowired
    private InterfaceFormation InterfaceFormation;

    public List<Formation> getAllFormations() {
        return InterfaceFormation.findAll();
    }
}