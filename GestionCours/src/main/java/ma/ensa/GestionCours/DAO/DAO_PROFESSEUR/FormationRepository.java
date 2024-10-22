package ma.ensa.GestionCours.DAO.DAO_PROFESSEUR;

import ma.ensa.GestionCours.Model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormationRepository extends JpaRepository<Formation, Integer> {

}
