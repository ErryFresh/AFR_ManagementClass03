package LogicTier;

import DataTier.AmministratoreDAO;
import ENTITY.Documento;


import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * dei Documenti evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
public class GestioneDocumenti {

    public GestioneDocumenti() {}

    public static AmministratoreDAO ad = AmministratoreDAO.getSingle_instance();

    public boolean addDocumento(Documento d){
        return ad.addDocumento(d);
    }

    public void removeDocumento(String d){
        ad.removeDocumento(d);
    }

    public void updateDocumento(Documento d){
         ad.updateDocumento(d);
    }
    public Documento ricercaIdD(String id){
        return ad.ricercaIdD(id);
    }

    public List<Documento> ricercaTuttiD(){
        return ad.ricercaTuttiDo();
    }

}
