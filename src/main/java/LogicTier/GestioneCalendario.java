package LogicTier;

import DataTier.DipendenteDAO;
import ENTITY.Calendario;
import ENTITY.EventoCalendario;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del Calendario evitando errori che possano comprometterne la qualitá e grantendo la sicurezza dei dati.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 */
public class GestioneCalendario {

    public GestioneCalendario() {
    }
    public static DipendenteDAO dp = DipendenteDAO.getSingle_instance();

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

    public Calendario ricercaRepC(int id){return dp.ricercaRepC(id);}

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

    public List<EventoCalendario> ricercaTuttiE(Date bound, String codiceCal){
        List<EventoCalendario> list = ricercaTuttiE();
        List<EventoCalendario> tmp = new ArrayList<EventoCalendario>();

        int mese = bound.getMonth()+1;
        int year = bound.getYear()+1900;

        for(EventoCalendario e : list){
            int meseE= Integer.parseInt(e.getData().split("-")[1]);
            int annoE= Integer.parseInt(e.getData().split("-")[0]);

            if(e.getCodiceCal().equals(codiceCal))
                if(meseE==mese && annoE==year)
                    tmp.add(e);
        }
        return tmp;
    }

}
