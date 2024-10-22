package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceFormation;
import ma.ensa.GestionCours.Model.Formation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormationService implements IServiceFormation {

    @Autowired
    private InterfaceFormation InterfaceFormation;

    @Override
    public List<Formation> getAllFormations() {
        return InterfaceFormation.findAll();
    }
}