package ma.ensa.GestionCours.Service.prof;

import ma.ensa.GestionCours.Model.Formation;
import ma.ensa.GestionCours.Model.Semestre;

import java.util.List;
import java.util.Map;
import java.util.Set;

public interface IServiceProf {

    public Set<Formation> getFormationsForAuthenticatedProfesseur(Integer id);

    public Map<String, Object> getSemestresForFormation(Integer id);

    public Map<String, Object> getModulesForSemestre(Integer id);

    public Map<String, Object> getMatieresForModule(Integer id);

}
