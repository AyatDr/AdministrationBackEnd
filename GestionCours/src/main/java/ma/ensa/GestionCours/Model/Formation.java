package ma.ensa.GestionCours.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "formation", schema = "jee")
public class Formation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_form", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 20)
    private String label;

    @Column(name = "description", nullable = false, length = 50)
    private String description;








    // One-to-Many avec Semestre
    @OneToMany(mappedBy = "formation", cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    @JsonManagedReference() // Gère la relation avec Semestre
    private List<Semestre> semestres;

    // One-to-Many avec Etudiant
    @OneToMany(mappedBy = "formation", fetch = FetchType.LAZY)
    @JsonManagedReference // Gère la relation avec Etudiant
    private List<Etudiant> etudiants;

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
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Semestre> getSemestres() {
        return semestres;
    }

    public void setSemestres(List<Semestre> semestres) {
        this.semestres = semestres;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}
