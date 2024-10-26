package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;
import ma.ensa.GestionCours.Model.Cours;
import org.springframework.data.jpa.repository.JpaRepository;
public interface InterfaceCours extends JpaRepository<Cours, Integer>{

}
