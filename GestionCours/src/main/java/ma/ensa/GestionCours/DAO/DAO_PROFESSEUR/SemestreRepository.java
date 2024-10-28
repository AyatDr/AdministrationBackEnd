package ma.ensa.GestionCours.DAO.DAO_PROFESSEUR;

import ma.ensa.GestionCours.Model.Semestre;
import ma.ensa.GestionCours.Model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SemestreRepository extends JpaRepository<Semestre, Integer> {
    List<Semestre> findByFormation(Formation formation);
}
