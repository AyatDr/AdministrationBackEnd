package ma.ensa.GestionCours.DTO.DTO_PROFESSEUR;

import java.util.List;

public class CourseResourcesDTO {

    private Integer id;
    private String label;
    private List<LienDTO> liens;
    private List<DocumentDTO> documents;

    public CourseResourcesDTO(Integer id, String label, List<LienDTO> liens, List<DocumentDTO> documents) {
        this.id = id;
        this.label = label;
        this.liens = liens;
        this.documents = documents;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public List<LienDTO> getLiens() {
        return liens;
    }

    public List<DocumentDTO> getDocuments() {
        return documents;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setLiens(List<LienDTO> liens) {
        this.liens = liens;
    }

    public void setDocuments(List<DocumentDTO> documents) {
        this.documents = documents;
    }
}