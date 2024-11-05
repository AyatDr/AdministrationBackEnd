package ma.ensa.GestionCours.DAO.DAO_PROFESSEUR;

import ma.ensa.GestionCours.Model.Prof;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfesseurRepository extends JpaRepository<Prof, Integer> {
    Optional<Prof> findByEmail(String email);
    Optional<Prof> findById(Integer id);
}

