package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceEtudiant;
import ma.ensa.GestionCours.Model.Etudiant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EtudiantService implements IServiceEtudiant {

    private final InterfaceEtudiant etudiantRepository;

    @Autowired
    public EtudiantService(InterfaceEtudiant etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Optional<Etudiant> findByEmail(String email) {
        return etudiantRepository.findByEmail(email);
    }

    @Override
    public Optional<Etudiant> findById(Integer id) {
        return etudiantRepository.findById(id);
    }
}
