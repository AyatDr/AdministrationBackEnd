package ma.ensa.GestionCours.DTO.DTO_PROFESSEUR;

public class NoteDTO {

    private Integer idNote;
    private String etudiant;
    private Float valeur;

    public NoteDTO(Integer idNote, String etudiant, Float valeur) {
        this.idNote = idNote;
        this.etudiant = etudiant;
        this.valeur = valeur;
    }

    public Integer getIdNote() {
        return idNote;
    }

    public String getEtudiant() {
        return etudiant;
    }

    public Float getValeur() {
        return valeur;
    }

    public void setIdNote(Integer idNote) {
        this.idNote = idNote;
    }

    public void setEtudiant(String etudiant) {
        this.etudiant = etudiant;
    }

    public void setValeur(Float valeur) {
        this.valeur = valeur;
    }
}
