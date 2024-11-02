package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;


import ma.ensa.GestionCours.Model.Document;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InterfaceDocument extends JpaRepository <Document, Integer>{
}
