package LogicTier;

import DataTier.AmministratoreDAO;
import Entity.Clientefornitore;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * dei ClientiFornitori evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
@Stateless
@LocalBean
public class GestioneClientiFornitori {
    public static AmministratoreDAO ad = AmministratoreDAO.getSingle_instance();

    public void addClienteFornitore(Clientefornitore cf){
        ad.addClienteFornitore(cf);
    }

    public void removeClienteFornitore(Clientefornitore cf){
        ad.removeClienteFornitore(cf);
    }

    public Clientefornitore updateClienteFornitore(Clientefornitore cf){
        return ad.updateClienteFornitore(cf);
    }

    public Clientefornitore ricercaIdCf(String id){
        return ad.ricercaIdCf(id);
    }

    public List<Clientefornitore> ricercaTuttiCf(){
        return ad.ricercaTuttiCf();
    }

    public List<Clientefornitore> ricercaTuttiCf(boolean scelta){
        return ad.ricercaTuttiCf(scelta);
    }
}
