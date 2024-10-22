package ma.ensa.GestionCours.Service.ServiceDirecteur;



import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceEnsegnant;
import ma.ensa.GestionCours.Model.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EnsegnantService implements IServiceEnsegnant {

    private final InterfaceEnsegnant enseignantRepository;

    @Autowired
    public EnsegnantService(InterfaceEnsegnant enseignantRepository) {
        this.enseignantRepository = enseignantRepository;
    }

    @Override
    public Optional<Prof> findByEmail(String email) {
        return enseignantRepository.findByEmail(email);
    }
    @Override
    public Optional<Prof> findById(Integer id) {
        return enseignantRepository.findById(id);
    }


}
