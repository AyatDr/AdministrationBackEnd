package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Directeur;
import ma.ensa.GestionCours.Model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InterfaceDirecteur extends JpaRepository<Directeur, Long> {
    Optional<Directeur> findByEmail(String email);
    Optional<Directeur> findById(Integer id);
}
