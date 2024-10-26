package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.Model.Matiere;

import java.util.Optional;

public interface IServiceMatiere {
    public Matiere saveMatiere(Matiere matiere);
    public Optional<Matiere> findById(Integer id);
    public void deleteMatiere(Integer MatiereId);
}
