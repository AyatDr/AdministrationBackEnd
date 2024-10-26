package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.Model.Module;
import ma.ensa.GestionCours.Model.Prof;

import java.util.Optional;

public interface IServiceProf {
    public Optional<Prof> findById(Integer id);
}
