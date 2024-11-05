package ma.ensa.GestionCours.DTO.DTO_PROFESSEUR;

import org.springframework.web.multipart.MultipartFile;

public class CreateDocumentDTO {

    private String label;

    private MultipartFile document;

    private Integer coursId;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public MultipartFile getDocument() {
        return document;
    }

    public void setDocument(MultipartFile file) {
        this.document = file;
    }

    public Integer getCoursId() {
        return coursId;
    }

    public void setCoursId(Integer coursId) {
        this.coursId = coursId;
    }
}