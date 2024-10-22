package ma.ensa.GestionCours.DAO.DAO_Auth;

import org.springframework.security.core.userdetails.UserDetails;
import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.DirecteurService;
import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.EnsegnantService;
import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.EtudiantService;
import ma.ensa.GestionCours.controller.auth.AuthResponse;
import ma.ensa.GestionCours.controller.auth.JwtUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import ma.ensa.GestionCours.Model.Directeur;
import ma.ensa.GestionCours.Model.Prof;
import ma.ensa.GestionCours.Model.Etudiant;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Service
public class AuthService {

    private final EtudiantService etudiantService;
    private final EnsegnantService enseignantService;
    private final DirecteurService directeurService;
    private final PasswordEncoder passwordEncoder;

    public AuthService(EtudiantService etudiantService, EnsegnantService enseignantService,
    DirecteurService directeurService, PasswordEncoder passwordEncoder) {
        this.etudiantService = etudiantService;
        this.enseignantService = enseignantService;
        this.directeurService = directeurService;
        this.passwordEncoder = passwordEncoder;
    }

    private static final Logger logger = LoggerFactory.getLogger(AuthService.class);



        public AuthResponse login(String email, String password) throws Exception {
            Object utilisateur = null;
            String nature = null;



            logger.info("Attempting to log in user with email: {}", email);

            // Vérification de l'étudiant
            Etudiant etudiant = etudiantService.findByEmail(email).orElse(null);
            if (etudiant != null) {
                utilisateur = etudiant;
                nature = "etudiant";
                logger.info("User found: {}", etudiant);
            } else {
                logger.info("No student found with email: {}", email);
            }

            // Vérification du professeur
            Prof enseignant = enseignantService.findByEmail(email).orElse(null);
            if (enseignant != null) {
                utilisateur = enseignant;
                nature = "prof";
                logger.info("User found: {}", enseignant);
            } else {
                logger.info("No professor found with email: {}", email);
            }

            // Vérification du directeur
            Directeur directeur = directeurService.findByEmail(email).orElse(null);
            if (directeur != null) {
                utilisateur = directeur;
                nature = "directeur";
                logger.info("User found: {}", directeur);
            } else {
                logger.info("No director found with email: {}", email);
            }

            // Si aucun utilisateur n'a été trouvé, lever une exception
            if (utilisateur == null) {
                logger.error("Utilisateur non trouvé pour l'email: {}", email);
                throw new Exception("Utilisateur non trouvé");
            }

            // Vérification du mot de passe
            String storedPassword;
            if (utilisateur instanceof Etudiant) {
                storedPassword = etudiant.getMdp();
            } else if (utilisateur instanceof Prof) {
                storedPassword = enseignant.getMdp();
            } else {
                storedPassword = directeur.getMdp();
            }

            if (!passwordEncoder.matches(password, storedPassword)) {
                logger.error("Mot de passe incorrect pour l'utilisateur: {}", email);
                throw new Exception("Mot de passe incorrect");
            }

            // Génération du token
            String token = JwtUtil.generateToken(email);
            logger.info("Login successful for user: {}", email);
            return new AuthResponse(utilisateur, nature, token);

        }


    }



