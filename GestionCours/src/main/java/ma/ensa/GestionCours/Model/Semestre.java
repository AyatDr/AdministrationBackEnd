package ma.ensa.GestionCours.Model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "semestre", schema = "jee")
public class Semestre {
    @Id
    @Column(name = "id_sem", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 10)
    private String label;

    @Column(name = "date_debut", nullable = false)
    private LocalDate dateDebut;

    @Column(name = "date_fin", nullable = false)
    private LocalDate dateFin;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_form", nullable = false)
    private Formation fkForm;

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

    public Formation getFkForm() {
        return fkForm;
    }

    public void setFkForm(Formation fkForm) {
        this.fkForm = fkForm;
    }

}