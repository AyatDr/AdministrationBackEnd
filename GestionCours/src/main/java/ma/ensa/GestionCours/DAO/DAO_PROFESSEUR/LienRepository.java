package ma.ensa.GestionCours.DAO.DAO_PROFESSEUR;

import ma.ensa.GestionCours.Model.Cours;
import ma.ensa.GestionCours.Model.Lien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LienRepository extends JpaRepository<Lien, Integer> {
    List<Lien> findByCours(Cours cours);
}
