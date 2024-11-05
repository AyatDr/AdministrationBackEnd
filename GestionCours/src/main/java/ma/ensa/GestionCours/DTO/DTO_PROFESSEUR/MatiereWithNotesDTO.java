package ma.ensa.GestionCours.DTO.DTO_PROFESSEUR;

import java.util.List;

public class MatiereWithNotesDTO {

    private Integer idMatiere;
    private String matiereLabel;
    private List<NoteDTO> notes;

    public MatiereWithNotesDTO(Integer idMatiere, String matiereLabel, List<NoteDTO> notes) {
        this.idMatiere = idMatiere;
        this.matiereLabel = matiereLabel;
        this.notes = notes;
    }

    public Integer getIdMatiere() {
        return idMatiere;
    }

    public String getMatiereLabel() {
        return matiereLabel;
    }

    public List<NoteDTO> getNotes() {
        return notes;
    }

    public void setIdMatiere(Integer idMatiere) {
        this.idMatiere = idMatiere;
    }

    public void setMatiereLabel(String matiereLabel) {
        this.matiereLabel = matiereLabel;
    }

    public void setNotes(List<NoteDTO> notes) {
        this.notes = notes;
    }
}
