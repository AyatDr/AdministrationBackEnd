package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceFormation;
import ma.ensa.GestionCours.Model.Formation;

import ma.ensa.GestionCours.Model.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FormationService implements IServiceFormation {

    @Autowired
    private InterfaceFormation InterfaceFormation;

    @Override
    public List<Formation> getAllFormations() {
        return InterfaceFormation.findAll();
    }

    // Enregistrer une nouvelle formation
    @Override
    public Formation saveFormation(Formation formation) {
        return InterfaceFormation.save(formation);
    }
    @Override
    public Optional<Formation> findById(Integer id) {
        return InterfaceFormation.findById(id);
    }

    @Override
    public void deleteFormation(Integer formationId) {
        InterfaceFormation.deleteById(formationId);
    }
    @Override
    public Formation getFormationEtudiant(Integer id) {

        return  InterfaceFormation.findFormationByStudentId(id);
    }
}