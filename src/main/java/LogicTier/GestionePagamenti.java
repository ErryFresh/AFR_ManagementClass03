package LogicTier;

import DataTier.AmministratoreDAO;
import Entity.Pagamento;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * dei Pagamenti evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
@Stateless
@LocalBean
public class GestionePagamenti {

    public static AmministratoreDAO ad = AmministratoreDAO.getSingle_instance();

    public void addPagamento(Pagamento p){
        ad.addPagamento(p);
    }

    public void removePagamento(Pagamento p){
        ad.removePagamento(p);
    }

    public Pagamento updatePagamento(Pagamento p){
        return ad.updatePagamento(p);
    }

    public Pagamento ricercaIdP(int id){
        return ad.ricercaIdP(id);
    }

    public List<Pagamento> ricercaTuttiP(){
        return ad.ricercaTuttiP();
    }
}
