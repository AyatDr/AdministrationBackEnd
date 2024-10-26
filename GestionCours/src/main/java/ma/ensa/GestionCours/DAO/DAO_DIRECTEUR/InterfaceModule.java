package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceModule extends JpaRepository<Module, Integer> {

}
