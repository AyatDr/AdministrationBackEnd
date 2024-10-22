package ma.ensa.GestionCours.DAO.DAO_PROFESSEUR;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import ma.ensa.GestionCours.Model.Matiere;
import ma.ensa.GestionCours.Model.Prof;
import ma.ensa.GestionCours.Model.Semestre;
import ma.ensa.GestionCours.Model.Formation;
import ma.ensa.GestionCours.Model.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Set;

@Service
public class ProfFormation {

    @Autowired
    private ProfesseurRepository professeurRepository;

    @Autowired
    private MatiereRepository matiereRepository;

    private static final Logger logger = LoggerFactory.getLogger(ProfFormation.class);

    public Set<Formation> getFormationsForAuthenticatedProfesseur(Integer id) {

        Prof professeur = professeurRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Professeur not found"));

        if (professeur == null) {
            throw new RuntimeException("Authenticated professeur not found.");
        }

        List<Matiere> matieres = matiereRepository.findByProfesseur(professeur);

        return matieres.stream()
                .map(Matiere::getModule)
                .map(Module::getSemestre)
                .map(Semestre::getFormation)
                .collect(Collectors.toSet());
    }
}
