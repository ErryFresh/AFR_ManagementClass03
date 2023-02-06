package LogicTier;

import DataTier.AmministratoreDAO;
import Entity.Prodottodocumento;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del ProdottoDocumento evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
@Stateless
@LocalBean
public class GestioneProdottoDocumento {
    public static AmministratoreDAO ad = AmministratoreDAO.getSingle_instance();

    public void addProdottoDocumento(Prodottodocumento pd){
        ad.addProdottoDocumento(pd);
    }

    public void removeProdottoDocumento(Prodottodocumento pd){
        ad.removeProdottoDocumento(pd);
    }

    public Prodottodocumento updateProdottoDocumento(Prodottodocumento pd){
        return ad.updateProdottoDocumento(pd);
    }

    public Prodottodocumento ricercaIdPd(String id){
        return ad.ricercaIdPd(id);
    }

    public List<Prodottodocumento> ricercaTuttiPd(){
        return ad.ricercaTuttiPd();
    }
}
