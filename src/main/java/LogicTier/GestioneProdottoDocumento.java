package LogicTier;

import DataTier.AmministratoreDAO;
import ENTITY.ProdottoDocumento;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del ProdottoDocumento evitando errori che possano comprometterne la qualitá e garantendo la sicurezza dei dati.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 */
public class GestioneProdottoDocumento {
    public static AmministratoreDAO ad = AmministratoreDAO.getSingle_instance();

    public void addProdottoDocumento(ProdottoDocumento pd){
        ad.addProdottoDocumento(pd);
    }

    public void removeProdottoDocumento(String codiceArt,String codiceDoc){
        ad.removeProdottoDocumento(codiceArt,codiceDoc);
    }

    public void updateProdottoDocumento(ProdottoDocumento pd){
       ad.updateProdottoDocumento(pd);
    }

    public ProdottoDocumento ricercaIdPd(String codiceArt,String codiceDoc){
        return ad.ricercaIdPd(codiceArt,codiceDoc);
    }

    public List<ProdottoDocumento> ricercaTuttiPd(){
        return ad.ricercaTuttiPd();
    }
}
