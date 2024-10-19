package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Directeur;
import ma.ensa.GestionCours.Model.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnsegnantService {

    private final InterfaceEnsegnant enseignantRepository;

    @Autowired
    public EnsegnantService(InterfaceEnsegnant enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    public Optional<Prof> findByEmail(String email) {
        return enseignantRepository.findByEmail(email);
    }
    public Optional<Prof> findById(Integer id) {
        return enseignantRepository.findById(id);
    }
}
