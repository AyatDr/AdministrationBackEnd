package ma.ensa.GestionCours.DAO.DAO_PROFESSEUR;

import ma.ensa.GestionCours.Model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SemestreRepository extends JpaRepository<Semestre, Integer> {
}
