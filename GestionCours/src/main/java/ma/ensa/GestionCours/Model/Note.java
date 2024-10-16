package ma.ensa.GestionCours.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "note", schema = "jee")
public class Note {
    @Id
    @Column(name = "id_note", nullable = false)
    private Integer id;

    @Column(name = "valeur", nullable = false)
    private Float valeur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_mat", nullable = false)
    private Matiere fkMat;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_etud", nullable = false)
    private Etudiant fkEtud;

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

    public Matiere getFkMat() {
        return fkMat;
    }

    public void setFkMat(Matiere fkMat) {
        this.fkMat = fkMat;
    }

    public Etudiant getFkEtud() {
        return fkEtud;
    }

    public void setFkEtud(Etudiant fkEtud) {
        this.fkEtud = fkEtud;
    }

}