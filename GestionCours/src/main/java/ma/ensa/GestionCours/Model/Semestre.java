package ma.ensa.GestionCours.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "semestre", schema = "jee")
public class Semestre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_sem", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 10)
    private String label;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    // Relation Many-to-One avec Formation
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_form", referencedColumnName = "id_form", nullable = false)
    @JsonBackReference // Évite les boucles infinies avec Formation
    private Formation formation;

    // Relation One-to-Many avec Module
    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Gère la relation avec Module
    private List<Module> modules;

    // Relation One-to-Many avec Etudiant
    @OneToMany(mappedBy = "semestre", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
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

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Formation getFormation() {
        return formation;
    }

    public void setFormation(Formation formation) {
        this.formation = formation;
    }

    public List<Module> getModules() {
        return modules;
    }

    public void setModules(List<Module> modules) {
        this.modules = modules;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}
