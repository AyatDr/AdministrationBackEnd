package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Etudiant;
import ma.ensa.GestionCours.Model.Formation;
import ma.ensa.GestionCours.Model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InterfaceEtudiant extends JpaRepository<Etudiant, Long> {
    Optional<Etudiant> findByEmail(String email);
    Optional<Etudiant> findById(Integer id);

    @Query("SELECT e.semestre FROM Etudiant e WHERE e.id = :etudiantId")
    Semestre findSemestreByEtudiantId(@Param("etudiantId") Integer etudiantId);

}
