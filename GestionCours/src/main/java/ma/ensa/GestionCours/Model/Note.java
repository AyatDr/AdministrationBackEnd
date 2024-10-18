package ma.ensa.GestionCours.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "note", schema = "jee")
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_note", nullable = false)
    private Integer id;

    @Column(name = "valeur", nullable = false)
    private Float valeur;

    // Many-to-One avec Matiere
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_mat", referencedColumnName = "id_mat", nullable = false)
    @JsonBackReference // Évite les boucles infinies avec Matiere
    private Matiere matiere;

    // Many-to-One avec Etudiant
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_etud", referencedColumnName = "id_etud", nullable = false)
    @JsonBackReference // Évite les boucles infinies avec Etudiant
    private Etudiant etudiant;

    // Getters et Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }

    public Matiere getMatiere() {
        return matiere;
    }

    public void setMatiere(Matiere matiere) {
        this.matiere = matiere;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
