package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceMatiere;
import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceModule;
import ma.ensa.GestionCours.Model.Matiere;
import ma.ensa.GestionCours.Model.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MatiereService implements IServiceMatiere {
    @Autowired
    private InterfaceMatiere InterfaceMatiere;
    @Override
    public Matiere saveMatiere(Matiere matiere) {
        return InterfaceMatiere.save(matiere);
    }
    @Override
    public Optional<Matiere> findById(Integer id) {
        return InterfaceMatiere.findById(id);
    }

    @Override
    public void deleteMatiere(Integer MatiereId) {
        InterfaceMatiere.deleteById(MatiereId);
    }
}
