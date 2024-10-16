package ma.ensa.GestionCours.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "cours", schema = "jee")
public class Cours {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cours", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false)
    private Integer label;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_mat", nullable = false)
    private Matiere fkMat;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getLabel() {
        return label;
    }

    public void setLabel(Integer label) {
        this.label = label;
    }

    public Matiere getFkMat() {
        return fkMat;
    }

    public void setFkMat(Matiere fkMat) {
        this.fkMat = fkMat;
    }

}