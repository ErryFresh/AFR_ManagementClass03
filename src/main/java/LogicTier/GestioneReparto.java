package LogicTier;

import DataTier.DipendenteDAO;
import Entity.Reparto;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del Reparto evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 */
@Stateless
@LocalBean
public class GestioneReparto {
    public static DipendenteDAO dp = DipendenteDAO.getInstance();

    public void addReparto(Reparto r){
        dp.addReparto(r);
    }

    public void removeReparto(Reparto r){
        dp.removeReparto(r);
    }

    public Reparto updateReparto(Reparto r){
        return dp.updateReparto(r);
    }

    public Reparto cercaIdR(int id){
        return dp.ricercaIdR(id);
    }

    public List<Reparto> ricercaTuttiR(){
        return dp.ricercaTuttiR();
    }
}
