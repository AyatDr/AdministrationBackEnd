package ma.ensa.GestionCours.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(name = "document", schema = "jee")
public class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_doc", nullable = false)
    private Integer id;

    @Column(name = "url_doc", nullable = false, length = 70)
    private String urlDoc;

    @Column(name = "label", nullable = false, length = 50)
    private String label;

    // Many-to-One avec Cours
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_cours", referencedColumnName = "id_cours", nullable = false)
    @JsonBackReference // Evite la boucle infinie avec Cours
    private Cours cours;

    // Getters et Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrlDoc() {
        return urlDoc;
    }

    public void setUrlDoc(String urlDoc) {
        this.urlDoc = urlDoc;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Cours getCours() {
        return cours;
    }

    public void setCours(Cours cours) {
        this.cours = cours;
    }
}
