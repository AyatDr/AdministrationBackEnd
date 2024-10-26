package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.Model.Formation;
import ma.ensa.GestionCours.Model.Semestre;

import java.util.Optional;

public interface IServiceSemestre {
    public Semestre saveSemestre(Semestre semestre) ;
    public Optional<Semestre> findById(Integer id);
    public void deleteSemestre(Integer semestreId);
}
