package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceEnsegnant;
import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceFormation;
import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceSemestre;
import ma.ensa.GestionCours.Model.Formation;
import ma.ensa.GestionCours.Model.Prof;
import ma.ensa.GestionCours.Model.Semestre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SemestreService implements IServiceSemestre{
    @Autowired
    private InterfaceSemestre InterfaceSemestre;

    @Override
    public Semestre saveSemestre(Semestre semestre) {
        return InterfaceSemestre.save(semestre);
    }
    @Override
    public Optional<Semestre> findById(Integer id) {
        return InterfaceSemestre.findById(id);
    }

    @Override
    public void deleteSemestre(Integer semstreId) {
        InterfaceSemestre.deleteById(semstreId);
    }



}
