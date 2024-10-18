package ma.ensa.GestionCours.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "lien", schema = "jee")
public class Lien {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lien", nullable = false)
    private Integer id;

    @Column(name = "url_lien", nullable = false, length = 70)
    private String urlLien;

    // Relation Many-to-One avec Cours
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_cours", referencedColumnName = "id_cours", nullable = false)
    @JsonBackReference // Évite les boucles infinies avec Cours
    private Cours cours;

    @Column(name = "label", nullable = false, length = 70)
    private String label;

    // Getters et Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlLien() {
        return urlLien;
    }

    public void setUrlLien(String urlLien) {
        this.urlLien = urlLien;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
