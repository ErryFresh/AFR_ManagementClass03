package LogicTier;

import DataTier.AmministratoreDAO;
import ENTITY.ClienteFornitore;
import java.util.List;
import java.util.regex.Pattern;

/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sara' mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del ClienteFornitore evitando errori che possano comprometterne la qualita' e garantendo la sicurezza dei dati.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 */
public class GestioneClientiFornitori {
    public static AmministratoreDAO ad = AmministratoreDAO.getSingle_instance();

    public boolean addClienteFornitore(ClienteFornitore cf){
        return ad.addClienteFornitore(cf);
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
