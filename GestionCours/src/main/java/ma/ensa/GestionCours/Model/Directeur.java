package ma.ensa.GestionCours.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "directeur", schema = "jee")
public class Directeur {
    @Id
    @Column(name = "id_dir", nullable = false)
    private Integer id;

    @Column(name = "nom", nullable = false, length = 10)
    private String nom;

    @Column(name = "prenom", nullable = false, length = 10)
    private String prenom;

    @Column(name = "email", nullable = false, length = 50)
    private String email;

    @Column(name = "mdp", nullable = false, length = 50)
    private String mdp;

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

}