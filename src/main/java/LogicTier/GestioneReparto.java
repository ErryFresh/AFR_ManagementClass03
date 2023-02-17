package LogicTier;

import DataTier.DipendenteDAO;
import ENTITY.Reparto;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sara' mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del Reparto evitando errori che possano comprometterne la qualita' e garantendo la sicurezza dei dati.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 */
public class GestioneReparto {
    public static DipendenteDAO dp = DipendenteDAO.getSingle_instance();

    public void addReparto(Reparto r){
        dp.addReparto(r);
    }

    public void removeReparto(int codiceRep){
        dp.removeReparto(codiceRep);
    }

    public void updateReparto(Reparto r){
         dp.updateReparto(r);
    }

    public Reparto cercaIdR(int id){
        return dp.ricercaIdR(id);
    }

    public List<Reparto> ricercaTuttiR(){
        return dp.ricercaTuttiR();
    }
}
