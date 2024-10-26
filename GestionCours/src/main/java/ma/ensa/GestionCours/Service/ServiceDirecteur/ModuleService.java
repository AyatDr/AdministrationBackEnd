package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceModule;
import ma.ensa.GestionCours.Model.Module;
import ma.ensa.GestionCours.Model.Semestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ModuleService implements IServiceModule {
    @Autowired
    private InterfaceModule InterfaceModule;

    @Override
    public Module saveModule(Module module) {
        return InterfaceModule.save(module);
    }
    @Override
    public Optional<Module> findById(Integer id) {
        return InterfaceModule.findById(id);
    }
    @Override
    public void deleteModule(Integer ModuleId) {
        InterfaceModule.deleteById(ModuleId);
    }
}
