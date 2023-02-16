package LogicTier;

import DataTier.MagazzinoDAO;
import ENTITY.Scaffale;
import java.util.List;

/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * dello Scaffale evitando errori che possano comprometterne la qualitá e garantendo la sicurezza dei dati.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 */
public class GestioneScaffale {

    public static MagazzinoDAO m = MagazzinoDAO.getSingle_instance();

    public void addScaffale(Scaffale s){m.addScaffale(s);}

    public void removeScaffale(int s){m.removeScaffale(s);}

    public void updateScaffale(Scaffale s){m.updateScaffale(s);}

    public Scaffale ricercaIdS(int id){return m.ricercaIdS(id);}

    public List<Scaffale> ricercaTuttiS(){return m.ricercaTuttiS();}

}
