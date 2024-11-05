package ma.ensa.GestionCours.DTO.DTO_PROFESSEUR;

public class CreateLienDTO {

    private String label;
    private String urlLien;
    private Integer coursId;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getUrlLien() {
        return urlLien;
    }

    public void setUrlLien(String urlLien) {
        this.urlLien = urlLien;
    }

    public Integer getCoursId() {
        return coursId;
    }

    public void setCoursId(Integer coursId) {
        this.coursId = coursId;
    }
}
