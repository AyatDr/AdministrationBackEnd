package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.Model.Formation;

import java.util.List;
import java.util.Optional;

public interface IServiceFormation {

    public List<Formation> getAllFormations();
    public Formation saveFormation(Formation formation);
    public Optional<Formation> findById(Integer id);
    public void deleteFormation(Integer formationId);
}
