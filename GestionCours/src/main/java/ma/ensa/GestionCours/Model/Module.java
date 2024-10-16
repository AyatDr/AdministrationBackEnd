package ma.ensa.GestionCours.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "module", schema = "jee")
public class Module {
    @Id
    @Column(name = "id_mod", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 20)
    private String label;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_sem", nullable = false)
    private Semestre fkSem;

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

    public Semestre getFkSem() {
        return fkSem;
    }

    public void setFkSem(Semestre fkSem) {
        this.fkSem = fkSem;
    }

}