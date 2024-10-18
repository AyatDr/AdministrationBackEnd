package ma.ensa.GestionCours.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "etudiant", schema = "jee")
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_etud", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 10)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 10)
    private String prenom;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "mdp", nullable = false, length = 50)
    private String mdp;

    // Many-to-One avec Formation
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_form", referencedColumnName = "id_form", nullable = false)
    @JsonBackReference // Évite les boucles infinies
    private Formation formation;

    // Many-to-One avec Semestre
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_sem", referencedColumnName = "id_sem", nullable = false)
    @JsonBackReference // Évite les boucles infinies
    private Semestre semestre;

    // One-to-Many avec Note
    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Gère la relation avec Note
    private List<Note> notes;

    // Getters et Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public Semestre getSemestre() {
        return semestre;
    }

    public void setSemestre(Semestre semestre) {
        this.semestre = semestre;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
}
