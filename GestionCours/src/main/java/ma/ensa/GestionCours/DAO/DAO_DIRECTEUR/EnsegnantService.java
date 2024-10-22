package ma.ensa.GestionCours.DAO.DAO_DIRECTEUR;

import ma.ensa.GestionCours.Model.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Collections;
import java.util.List;

@Service
public class EnsegnantService implements UserDetailsService {

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

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Prof professeur = enseignantRepository.findByEmail(email).orElse(null);

        if (professeur == null) {
            throw new UsernameNotFoundException("Professeur not found with email: " + email);
        }

        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority("ROLE_PROFESSEUR"));

        return new org.springframework.security.core.userdetails.User(
                professeur.getEmail(),
                professeur.getMdp(),
                authorities
        );
    }
}
