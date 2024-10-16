package ma.ensa.GestionCours.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fromation", schema = "jee")
public class Formation {
    @Id
    @Column(name = "id_form", nullable = false)
    private Integer id;

    @Column(name = "label", nullable = false, length = 20)
    private String label;

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

}