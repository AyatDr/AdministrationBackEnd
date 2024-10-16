package ma.ensa.GestionCours.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "etudiant", schema = "jee")
public class Etudiant {
    @Id
    @Column(name = "id_etud", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 10)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 10)
    private String prenom;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "mdp", nullable = false, length = 50)
    private String mdp;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_form", nullable = false)
    private Formation fkForm;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "fk_sem", nullable = false)
    private Semestre fkSem;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Formation getFkForm() {
        return fkForm;
    }

    public void setFkForm(Formation fkForm) {
        this.fkForm = fkForm;
    }

    public Semestre getFkSem() {
        return fkSem;
    }

    public void setFkSem(Semestre fkSem) {
        this.fkSem = fkSem;
    }

}