package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.Model.Cours;
import ma.ensa.GestionCours.Model.Matiere;

import java.util.Optional;

public interface IServiceCours {
    public Cours saveCours(Cours cours);
    public void deleteCours(Integer coursId);
    public Optional<Cours> findById(Integer id);
}
