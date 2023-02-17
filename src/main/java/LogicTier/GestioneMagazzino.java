package LogicTier;

import DataTier.MagazzinoDAO;
import ENTITY.Magazzino;
import ENTITY.Scaffale;

import java.util.List;

/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sara' mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del Magazzino evitando errori che possano comprometterne la qualita' e garantendo la sicurezza dei dati.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 */
public class GestioneMagazzino {

    public GestioneMagazzino(){}

    public static MagazzinoDAO m = MagazzinoDAO.getSingle_instance();

    public void addMagazzino(Magazzino mag){m.addMagazzino(mag);}

    public void removeMagazzino(int mag){m.removeMagazzino(mag);}

    public void updateMagazzino(Magazzino mag){m.updateMagazzino(mag);}

    public Magazzino ricercaIdC(int id){return m.ricercaIdM(id);}

    public List<Magazzino> ricercaTuttiM(){return m.ricercaTuttiM();}
}
