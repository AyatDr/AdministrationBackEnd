package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceEtudiant;
import ma.ensa.GestionCours.DAO.DAO_PROFESSEUR.FormationRepository;
import ma.ensa.GestionCours.Model.Etudiant;
import ma.ensa.GestionCours.Model.Formation;
import ma.ensa.GestionCours.Model.Semestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtudiantService implements IServiceEtudiant {

    private final InterfaceEtudiant etudiantRepository;
    private final FormationRepository formationRepository;

    @Autowired
    public EtudiantService(InterfaceEtudiant etudiantRepository, FormationRepository formationRepository) {
        this.etudiantRepository = etudiantRepository;
        this.formationRepository = formationRepository;
    }

    @Override
    public Optional<Etudiant> findByEmail(String email) {
        return etudiantRepository.findByEmail(email);
    }

    @Override
    public Optional<Etudiant> findById(Integer id) {
        return etudiantRepository.findById(id);
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }

    @Override
    public Semestre getSemestreByEtudiant(Integer id) {
        return   etudiantRepository.findSemestreByEtudiantId(id);
    }
}




