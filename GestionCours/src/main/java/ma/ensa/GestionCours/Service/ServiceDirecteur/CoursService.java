package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceCours;
import ma.ensa.GestionCours.Model.Cours;
import ma.ensa.GestionCours.Model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CoursService implements IServiceCours {
    @Autowired
    private InterfaceCours InterfaceCours;
    @Override
    public Cours saveCours(Cours module) {
        return InterfaceCours.save(module);
    }
    @Override
    public void deleteCours(Integer coursId) {
        InterfaceCours.deleteById(coursId);
    }
    @Override
    public Optional<Cours> findById(Integer id) {
        return InterfaceCours.findById(id);
    }
}
