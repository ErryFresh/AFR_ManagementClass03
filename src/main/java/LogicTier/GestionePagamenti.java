package LogicTier;

import DataTier.AmministratoreDAO;
import ENTITY.Pagamento;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sara' mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del Pagamento evitando errori che possano comprometterne la qualita' e garantendo la sicurezza dei dati.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 */
public class GestionePagamenti {

    public static AmministratoreDAO ad = AmministratoreDAO.getSingle_instance();

    public void addPagamento(Pagamento p){
        ad.addPagamento(p);
    }

    public void removePagamento(int nTransazione){
        ad.removePagamento(nTransazione);
    }

    public void updatePagamento(Pagamento p){
        ad.updatePagamento(p);
    }

    public Pagamento ricercaIdP(int id){
        return ad.ricercaIdP(id);
    }

    public List<Pagamento> ricercaTuttiP(){
        return ad.ricercaTuttiP();
    }
}
