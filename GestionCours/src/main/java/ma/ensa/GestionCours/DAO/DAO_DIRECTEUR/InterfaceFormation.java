package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;
import ma.ensa.GestionCours.Model.Formation;


import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceFormation extends JpaRepository<Formation, Integer> {
}
