package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Etudiant;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface InterfaceEtudiant extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByEmail(String email);
    Optional<Etudiant> findById(Integer id);
}
