package ma.ensa.GestionCours.DTO.DTO_PROFESSEUR;

public class DocumentDTO {

    private Integer id;
    private String label;
    private String urlDoc;

    public DocumentDTO(Integer id, String label, String urlDoc) {
        this.id = id;
        this.label = label;
        this.urlDoc = urlDoc;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getUrlDoc() {
        return urlDoc;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public void setUrlDoc(String urlDoc) {
        this.urlDoc = urlDoc;
    }
}