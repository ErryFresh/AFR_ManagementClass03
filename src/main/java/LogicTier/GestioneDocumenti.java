package LogicTier;

import DataTier.AmministratoreDAO;
import Entity.Documento;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * dei Documenti evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
@Stateless
@LocalBean
public class GestioneDocumenti {

    public static AmministratoreDAO ad = AmministratoreDAO.getSingle_instance();

    public void addDocumento(Documento d){
        ad.addDocumento(d);
    }

    public void removeDocumento(Documento d){
        ad.removeDocumento(d);
    }

    public Documento updateDocumento(Documento d){
        return ad.updateDocumento(d);
    }
    public Documento ricercaIdD(String id){
        return ad.ricercaIdD(id);
    }

    public List<Documento> ricercaTuttiD(){
        return ad.ricercaTuttiDo();
    }
}
