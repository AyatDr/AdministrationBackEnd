package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EtudiantService {

    private final InterfaceEtudiant etudiantRepository;

    @Autowired
    public EtudiantService(InterfaceEtudiant etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    public Optional<Etudiant> findByEmail(String email) {
        return etudiantRepository.findByEmail(email);
    }
    public Optional<Etudiant> findById(Integer id) {
        return etudiantRepository.findById(id);
    }
}
