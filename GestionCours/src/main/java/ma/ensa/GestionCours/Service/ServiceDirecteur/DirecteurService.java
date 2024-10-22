package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceDirecteur;
import ma.ensa.GestionCours.Model.Directeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DirecteurService implements IServiceDirecteur {

    private final InterfaceDirecteur directeurRepository;

    @Autowired
    public DirecteurService(InterfaceDirecteur directeurRepository) {
        this.directeurRepository = directeurRepository;
    }

    @Override
    public Optional<Directeur> findByEmail(String email) {
        return directeurRepository.findByEmail(email);
    }

    @Override
    public Optional<Directeur> findById(Integer id) {
        return directeurRepository.findById(id);
    }
}