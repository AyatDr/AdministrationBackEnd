package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;
import ma.ensa.GestionCours.Model.Formation;


import ma.ensa.GestionCours.Model.Semestre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InterfaceFormation extends JpaRepository<Formation, Integer> {
    Optional<Formation> findById(Integer id);
}
