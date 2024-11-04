package ma.ensa.GestionCours.Service.prof;

import ma.ensa.GestionCours.DTO.DTO_PROFESSEUR.*;
import ma.ensa.GestionCours.Model.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IServiceProf {

    public Set<Formation> getFormationsForAuthenticatedProfesseur(Integer id);

    public Map<String, Object> getSemestresForFormation(Integer id);

    public Map<String, Object> getModulesForSemestre(Integer id);

    public Map<String, Object> getMatieresForModule(Integer id);

    public Map<String, Object> getCoursForMatiere(Integer id);

    public Cours createCours(CoursDTO coursDTO);

    public Cours getCours(Integer id);

    public Cours updateCoursLabel(CoursUpdateDTO coursUpdateDTO);

    public void deleteCoursById(Integer id);

    public CourseResourcesDTO getCourseResources(Integer coursId);

    public Lien createLien(String label, String urlLien, Integer coursId);

    public void deleteLienById(Integer id);

    public Document createDocument(CreateDocumentDTO dto) throws IOException;

    public void deleteDocumentById(Integer id) throws IOException;

    public MatiereWithNotesDTO getNotesByMatiereId(Integer matiereId);

    public Note updateNote(Integer noteId, float newValue);
}
