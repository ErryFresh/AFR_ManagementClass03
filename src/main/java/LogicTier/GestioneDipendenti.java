package LogicTier;

import DataTier.DipendenteDAO;
import ENTITY.Dipendente;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * dei Dipendenti evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
public class GestioneDipendenti {

    public GestioneDipendenti() {
    }

    public static DipendenteDAO dp = DipendenteDAO.getInstance();

    public void addDipendente(Dipendente d){
        dp.addDipendenti(d);
    }

    public void removeDipendente(String matricola){
        dp.removeDipendente(matricola);
    }

    public void updateDipendente(Dipendente d){
        dp.updateDipendente(d);
    }

    public Dipendente ricercaIdD(String id){
        return dp.ricercaIdD(id);
    }

    public List<Dipendente> ricercaTuttiD(){
        return dp.ricercaTuttiD();
    }
}
