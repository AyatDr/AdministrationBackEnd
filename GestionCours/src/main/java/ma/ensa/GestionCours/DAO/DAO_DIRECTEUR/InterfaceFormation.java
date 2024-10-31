package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;
import ma.ensa.GestionCours.Model.Formation;


import ma.ensa.GestionCours.Model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InterfaceFormation extends JpaRepository<Formation, Integer> {
    @Query("SELECT f FROM Formation f JOIN f.etudiants e WHERE e.id = :studentId")
    Formation findFormationByStudentId(@Param("studentId") Integer studentId);

}
