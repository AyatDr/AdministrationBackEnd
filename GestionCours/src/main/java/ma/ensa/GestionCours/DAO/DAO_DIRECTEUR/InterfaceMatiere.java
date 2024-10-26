package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Formation;
import ma.ensa.GestionCours.Model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceMatiere extends JpaRepository<Matiere, Integer> {
}
