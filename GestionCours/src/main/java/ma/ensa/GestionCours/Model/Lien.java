package ma.ensa.GestionCours.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "lien", schema = "jee")
public class Lien {
    @Id
    @Column(name = "id_lien", nullable = false)
    private Integer id;

    @Column(name = "url_lien", nullable = false, length = 70)
    private String urlLien;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_cours", nullable = false)
    private Cours fkCours;

    @Column(name = "label", nullable = false, length = 70)
    private String label;

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

    public Cours getFkCours() {
        return fkCours;
    }

    public void setFkCours(Cours fkCours) {
        this.fkCours = fkCours;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

}