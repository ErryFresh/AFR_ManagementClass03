package LogicTier;

import DataTier.DipendenteDAO;
import Entity.Dipendente;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * dei Dipendenti evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
@Stateless
@LocalBean
public class GestioneDipendenti {

   public static DipendenteDAO dp = DipendenteDAO.getInstance();

    public void addDipendente(Dipendente d){
        dp.addDipendenti(d);
    }

    public void removeDipendente(Dipendente d){
        dp.removeDipendente(d);
    }

    public Dipendente updateDipendente(Dipendente d){
        return dp.updateDipendente(d);
    }

    public Dipendente ricercaIdD(String id){
        return dp.ricercaIdD(id);
    }

    public List<Dipendente> ricercaTuttiD(){
        return dp.ricercaTuttiD();
    }
}
