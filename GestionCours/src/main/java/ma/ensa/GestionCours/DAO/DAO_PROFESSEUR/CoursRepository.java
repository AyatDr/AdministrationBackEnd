package ma.ensa.GestionCours.DAO.DAO_PROFESSEUR;

import ma.ensa.GestionCours.Model.Cours;
import ma.ensa.GestionCours.Model.Matiere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursRepository extends JpaRepository<Cours, Integer> {
    List<Cours> findByMatiere(Matiere matiere);
}
