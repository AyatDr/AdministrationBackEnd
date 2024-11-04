package ma.ensa.GestionCours.DTO.DTO_PROFESSEUR;

public class LienDTO {

    private Integer id;
    private String label;
    private String urlLien;

    public LienDTO(Integer id, String label, String urlLien) {
        this.id = id;
        this.label = label;
        this.urlLien = urlLien;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getUrlLien() {
        return urlLien;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setUrlLien(String urlLien) {
        this.urlLien = urlLien;
    }
}