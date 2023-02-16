package LogicTier;

import DataTier.MagazzinoDAO;
import ENTITY.Prodotto;
import java.util.List;
import java.util.Random;

/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del Prodotto evitando errori che possano comprometterne la qualitá e garantendo la sicurezza dei dati.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 */
public class GestioneProdotto {

    public static MagazzinoDAO m = MagazzinoDAO.getSingle_instance();

    public boolean addProdotto(Prodotto p){return m.addProdotto(p);}

    public void removeProdotto(String p){m.removeProdotto(p);}

    public void updateProdotto(Prodotto p){m.updateProdotto(p);}

    public Prodotto ricercaIdP(String id){return m.ricercaIdP(id);}

    public List<Prodotto> ricercaTuttiP(){return m.ricercaTuttiP();}

    /**
     * In questo metodo viene generata la chiave primaria del prodotto, i primi due valori sono fissi (PR)
     * mentre gli altri sei sono generati in maniera random
     * @return chiave primaria del prodotto
     */
    public String generaChiaveProdotto(){
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(8);
        sb.append('P');
        sb.append('R');
        for (int i = 2; i < 8; i++)
            sb.append(rnd.nextInt(10));
        return sb.toString();
    }
}
