package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.Model.Prof;
import java.util.List;
import java.util.Optional;

public interface IServiceEnsegnant {
    public Optional<Prof> findByEmail(String email);
    public Optional<Prof> findById(Integer id);
    public List<Prof> getAllProfesseurs();
}
