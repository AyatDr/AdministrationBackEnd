package ma.ensa.GestionCours.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "cours", schema = "jee")
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cours", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false)
    private String label;

    // Many-to-One avec Matiere
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_mat", referencedColumnName = "id_mat", nullable = false)
    @JsonBackReference // Evite la boucle infinie avec Matiere
    private Matiere matiere;

    // One-to-Many avec Lien
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Gère la relation avec Lien
    private List<Lien> liens;

    // One-to-Many avec Document
    @OneToMany(mappedBy = "cours", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference // Gère la relation avec Document
    private List<Document> documents;

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

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public List<Lien> getLiens() {
        return liens;
    }

    public void setLiens(List<Lien> liens) {
        this.liens = liens;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}
