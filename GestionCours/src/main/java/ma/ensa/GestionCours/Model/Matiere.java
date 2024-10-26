package ma.ensa.GestionCours.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "matiere", schema = "jee")
public class Matiere {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_mat", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 20)
    private String label;
    @Column(name = "description", nullable = false, length = 50)
    private String description;

    // Many-to-One avec Professeur
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_prof", referencedColumnName = "id", nullable = false)
   // Évite les boucles infinies avec Professeur
    @JsonManagedReference
    private Prof professeur;

    // Many-to-One avec Module
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_mod", referencedColumnName = "id_mod", nullable = false)
    @JsonBackReference // Évite les boucles infinies avec Module
    private Module module;

    // One-to-Many avec Cours
    @OneToMany(mappedBy = "matiere",cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @JsonManagedReference // Gère la relation avec Cours
    private List<Cours> cours;

    // One-to-Many avec Note
    @OneToMany(mappedBy = "matiere", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @JsonManagedReference // Gère la relation avec Note
    private List<Note> notes;






    // Getters et Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Prof getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Prof professeur) {
        this.professeur = professeur;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public List<Cours> getCours() {
        return cours;
    }

    public void setCours(List<Cours> cours) {
        this.cours = cours;
    }

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
