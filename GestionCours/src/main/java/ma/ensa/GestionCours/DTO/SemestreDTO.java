package ma.ensa.GestionCours.DTO;


import java.time.LocalDate;
import java.util.List;

public class SemestreDTO {
    private String label;
    private String dateDebut;  // Au format 'YYYY-MM-DD'
    private String dateFin;    // Au format 'YYYY-MM-DD'
    private Integer formationId;

    // Getters et Setters
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }

    public String getDateDebut() { return dateDebut; }
    public void setDateDebut(String dateDebut) { this.dateDebut = dateDebut; }

    public String getDateFin() { return dateFin; }
    public void setDateFin(String dateFin) { this.dateFin = dateFin; }

    public Integer getFormationId() { return formationId; }
    public void setFormationId(Integer formationId) { this.formationId = formationId; }
}
