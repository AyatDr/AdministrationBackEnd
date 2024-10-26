package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Directeur;
import ma.ensa.GestionCours.Model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterfaceSemestre extends JpaRepository<Semestre, Integer> {
    Optional<Semestre> findById(Integer id);
}
