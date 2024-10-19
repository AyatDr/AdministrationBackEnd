package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Directeur;
import ma.ensa.GestionCours.Model.Prof;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InterfaceEnsegnant extends JpaRepository<Prof, Long> {
    Optional<Prof> findByEmail(String email);
    Optional<Prof> findById(Integer id);
}
