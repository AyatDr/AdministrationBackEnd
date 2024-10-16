package ma.ensa.GestionCours.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "document", schema = "jee")
public class Document {
    @Id
    @Column(name = "id_doc", nullable = false)
    private Integer id;

    @Column(name = "url_doc", nullable = false, length = 70)
    private String urlDoc;

    @Column(name = "label", nullable = false, length = 50)
    private String label;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_cours", nullable = false)
    private Cours fkCours;

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

    public Cours getFkCours() {
        return fkCours;
    }

    public void setFkCours(Cours fkCours) {
        this.fkCours = fkCours;
    }

}