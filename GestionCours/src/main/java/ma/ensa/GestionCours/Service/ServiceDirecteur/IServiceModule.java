package ma.ensa.GestionCours.Service.ServiceDirecteur;
import ma.ensa.GestionCours.Model.Module;

import java.util.Optional;

public interface IServiceModule {
    public Module saveModule(Module module);
    public Optional<Module> findById(Integer id);
    public void deleteModule(Integer ModuleId);
}
