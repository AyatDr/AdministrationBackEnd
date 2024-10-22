package ma.ensa.GestionCours.DAO.DAO_PROFESSEUR;

import ma.ensa.GestionCours.Model.Module;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModuleRepository extends JpaRepository<Module, Integer> {
}
