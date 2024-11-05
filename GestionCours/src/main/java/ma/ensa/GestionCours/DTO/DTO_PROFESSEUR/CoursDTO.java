package ma.ensa.GestionCours.DTO.DTO_PROFESSEUR;

public class CoursDTO {
    private String label;
    private Integer matiereId;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Integer getMatiereId() {
        return matiereId;
    }

    public void setMatiereId(Integer matiereId) {
        this.matiereId = matiereId;
    }
}
