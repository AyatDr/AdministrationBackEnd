package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.Model.Etudiant;

import java.util.Optional;

public interface IServiceEtudiant {

    public Optional<Etudiant> findByEmail(String email);
    public Optional<Etudiant> findById(Integer id);
}
