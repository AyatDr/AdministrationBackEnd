package ma.ensa.GestionCours.DTO;

public class MatiereDTO {
    private String label;
    private Integer moduleId;
    private String description;
    private Integer professeurId;
    public Integer getProfesseurId() {
        return professeurId;
    }

    public void setProfesseurId(Integer professeurId) {
        this.professeurId = professeurId;
    }


    // Getters et Setters
    public String getLabel() { return label; }
    public void setLabel(String label) { this.label = label; }



    public Integer getModuleId() { return moduleId; }
    public void setModuleId(Integer moduleId) { this.moduleId = moduleId; }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
