package ma.ensa.GestionCours.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "matiere", schema = "jee")
public class Matiere {
    @Id
    @Column(name = "id_mat", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 20)
    private String label;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_mod", nullable = false)
    private Module fkMod;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_prof", nullable = false)
    private Prof fkProf;

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

    public Module getFkMod() {
        return fkMod;
    }

    public void setFkMod(Module fkMod) {
        this.fkMod = fkMod;
    }

    public Prof getFkProf() {
        return fkProf;
    }

    public void setFkProf(Prof fkProf) {
        this.fkProf = fkProf;
    }

}