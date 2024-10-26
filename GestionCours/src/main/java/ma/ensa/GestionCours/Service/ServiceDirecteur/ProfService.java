package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceEnsegnant;
import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceModule;
import ma.ensa.GestionCours.Model.Module;
import ma.ensa.GestionCours.Model.Prof;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class ProfService  implements IServiceProf{
    @Autowired
    private InterfaceEnsegnant InterfaceProf;
    @Override
    public Optional<Prof> findById(Integer id) {
        return InterfaceProf.findById(id);
    }
}
