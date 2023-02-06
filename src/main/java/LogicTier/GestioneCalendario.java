package LogicTier;

import DataTier.DipendenteDAO;
import Entity.Calendario;
import Entity.Evento;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del Calendario evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
@Stateless
@LocalBean
public class GestioneCalendario {
    public static DipendenteDAO dp = DipendenteDAO.getInstance();

    public void addCalendario(Calendario c){
        dp.addCalendario(c);
    }

    public void removeCalendario(Calendario c){
        dp.removeCalendario(c);
    }

    public Calendario updateCalendario(Calendario c){
        return dp.updateCalendario(c);
    }

    public Calendario ricercaIdC(String id){
        return dp.ricercaIdC(id);
    }

    public List<Calendario> ricercaTuttiC(){
        return dp.ricercaTuttiC();
    }

    public void addEvento(Evento e){
        dp.addEvento(e);
    }

    public void removeEvento(Evento e){
        dp.removeEvento(e);
    }

    public Evento updateEvento(Evento e){
        return dp.updateEvento(e);
    }

    public Evento ricercaIdE(String id){
        return dp.ricercaIdE(id);
    }

    public List<Evento> ricercaTuttiE(){
        return dp.ricercaTuttiE();
    }

}
