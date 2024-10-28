package ma.ensa.GestionCours.DAO.DAO_PROFESSEUR;

import ma.ensa.GestionCours.Model.Prof;
import ma.ensa.GestionCours.Model.Matiere;
import ma.ensa.GestionCours.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MatiereRepository extends JpaRepository<Matiere, Integer> {

    List<Matiere> findByProfesseur(Prof professeur);

    List<Matiere> findByModule(Module module);
}