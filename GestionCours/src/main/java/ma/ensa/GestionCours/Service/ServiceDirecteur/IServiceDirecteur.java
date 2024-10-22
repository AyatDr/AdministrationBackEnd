package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.Model.Directeur;

import java.util.Optional;

public interface IServiceDirecteur {

    public Optional<Directeur> findByEmail(String email);
    public Optional<Directeur> findById(Integer id);
}
