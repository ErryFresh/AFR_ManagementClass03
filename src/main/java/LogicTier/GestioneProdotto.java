package LogicTier;

import DataTier.MagazzinoDAO;
import ENTITY.Prodotto;
import java.util.List;
import java.util.Random;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del Prodotto evitando errori che possano comprometterne la qualitá e grandendo la sicurezza dei dati.
 * L'interfaccia contiene azioni CRUD, due tipi di ricerca per ID e generale e un metodo per la creazione della chiave del Prodotto.
 */
public class GestioneProdotto {

    public static MagazzinoDAO m = MagazzinoDAO.getSingle_instance();

    public void addProdotto(Prodotto p){m.addProdotto(p);}

    public void removeProdotto(String p){m.removeProdotto(p);}

    public void updateProdotto(Prodotto p){m.updateProdotto(p);}

    public Prodotto ricercaIdP(String id){return m.ricercaIdP(id);}

    public List<Prodotto> ricercaTuttiP(){return m.ricercaTuttiP();}

    /**
     * La chiave del Prodotto da inserire viene generata automaticamente dal sistema tramite questo metodo
     * inserendo come primi due valori del codice "PR"
     * @return String contenente la chiave del prodtto.
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
