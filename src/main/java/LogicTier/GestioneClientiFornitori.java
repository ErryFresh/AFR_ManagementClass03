package LogicTier;

import DataTier.AmministratoreDAO;
import ENTITY.ClienteFornitore;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * dei ClientiFornitori evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
public class GestioneClientiFornitori {
    public static AmministratoreDAO ad = AmministratoreDAO.getSingle_instance();

    public void addClienteFornitore(ClienteFornitore cf){
        ad.addClienteFornitore(cf);
    }

    public void removeClienteFornitore(String cf){
        ad.removeClienteFornitore(cf);
    }

    public void updateClienteFornitore(ClienteFornitore cf){
        ad.updateClienteFornitore(cf);
    }

    public ClienteFornitore ricercaIdCf(String id){
        return ad.ricercaIdCf(id);
    }

    public List<ClienteFornitore> ricercaTuttiCf(){
        return ad.ricercaTuttiCf();
    }

    public List<ClienteFornitore> ricercaTuttiCfS(boolean scelta){
        return ad.ricercaTuttiCfS(scelta);
    }
}
