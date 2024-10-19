package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Directeur;
import ma.ensa.GestionCours.Model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirecteurService {

    private final InterfaceDirecteur directeurRepository;

    @Autowired
    public DirecteurService(InterfaceDirecteur directeurRepository) {
        this.directeurRepository = directeurRepository;
    }

    public Optional<Directeur> findByEmail(String email) {
        return directeurRepository.findByEmail(email);
    }
    public Optional<Directeur> findById(Integer id) {
        return directeurRepository.findById(id);
    }
}
