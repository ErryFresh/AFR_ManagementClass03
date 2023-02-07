package LogicTier;

import DataTier.DipendenteDAO;
import ENTITY.Calendario;
import ENTITY.EventoCalendario;
import java.util.List;

/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del Calendario evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
public class GestioneCalendario {
    public static DipendenteDAO dp = DipendenteDAO.getInstance();

    public void addCalendario(Calendario c){
        dp.addCalendario(c);
    }

    public void removeCalendario(String codiceCal){
        dp.removeCalendario(codiceCal);
    }

    public void updateCalendario(Calendario c){
        dp.updateCalendario(c);
    }

    public Calendario ricercaIdC(String id){
        return dp.ricercaIdC(id);
    }

    public List<Calendario> ricercaTuttiC(){
        return dp.ricercaTuttiC();
    }

    public void addEvento(EventoCalendario e){
        dp.addEvento(e);
    }

    public void removeEvento(String codiceEv){
        dp.removeEvento(codiceEv);
    }

    public void updateEvento(EventoCalendario e){
        dp.updateEvento(e);
    }

    public EventoCalendario ricercaIdE(String id){
        return dp.ricercaIdE(id);
    }

    public List<EventoCalendario> ricercaTuttiE(){
        return dp.ricercaTuttiE();
    }

}
