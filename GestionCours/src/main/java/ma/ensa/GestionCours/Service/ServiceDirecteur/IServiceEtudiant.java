package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.Model.Etudiant;
import ma.ensa.GestionCours.Model.Formation;
import ma.ensa.GestionCours.Model.Semestre;

import java.util.List;
import java.util.Optional;

public interface IServiceEtudiant {

    public Optional<Etudiant> findByEmail(String email);
    public Optional<Etudiant> findById(Integer id);
    public List<Etudiant> getAllEtudiants();
    public Semestre getSemestreByEtudiant(Integer id);
    public float getNoteEtudiantByMatiere(Integer idEtudiant , Integer idMatiere);

}
