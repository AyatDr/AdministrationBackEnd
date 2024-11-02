package ma.ensa.GestionCours.Service.ServiceDirecteur;

import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceDirecteur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.ensa.GestionCours.Model.Document;
import ma.ensa.GestionCours.DAO.DAO_DIRECTEUR.InterfaceDocument;

@Service
public class DocumentService implements IServiceDocument  {


    private final InterfaceDocument InterfaceDocument ;

    @Autowired
    public DocumentService(InterfaceDocument InterfaceDocument) {
        this.InterfaceDocument = InterfaceDocument;
    }


    @Override
    public String getDocumentUrlById(Integer id) {
        return InterfaceDocument.findById(id)
                .map(Document::getUrlDoc) // Using urlDoc field
                .orElse(null);
    }
}
