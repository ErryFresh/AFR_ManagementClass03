package DataTier;

import ENTITY.*;
import jakarta.inject.Singleton;

import java.util.List;


/**
 * Il seguente DAO incorpora Magazzino,Prodotto,Scaffale,ProdottoScaffale, è possibile effettuare query relative all'aggiunta, modifica e cancellazione
 * degli oggetti all'interno del database
 */
@Singleton
public class MagazzinoDAO {

    private MagazzinoDAO(){}

    private static MagazzinoDAO single_instance = null;
    public static MagazzinoDAO getInstance(){
        if(single_instance == null){
            synchronized (MagazzinoDAO.class){
                if(single_instance ==  null)
                    single_instance = new MagazzinoDAO();
            }
        }

        return single_instance;
    }

    /**
     *
     * @param m Magazzino su cui effettuare aggiunta, rimozione e aggiornamento del database
     */
    public void addMagazzino(Magazzino m){

    }

    public void removeMagazzino(String codiceMag){
    }

    public Magazzino updateMagazzino(Magazzino m){

    }

    /**
     *
     * @param p Prodotto su cui effettuare aggiunta, rimozione e aggiornamento del database
     */
    public void addProdotto(Prodotto p){

    }

    public void removeProdotto(String codiceSc){

    }

    public Prodotto updateProdotto(Prodotto p){

    }

    /**
     *
     * @param s Scaffale su cui effettuare aggiunta, rimozione e aggiornamento del database
     */

    public void addScaffale(Scaffale s){

    }

    public void removeScaffale(Scaffale s){

    }

    public Scaffale updateScaffale(Scaffale s){

    }

    /**
     *
     * @param ps ProdottoScaffale su cui effettuare aggiunta, rimozione e aggiornamento del database
     */
    public void addProdottoScaffale(ProdottoScaffale ps){

    }

    public void removeProdottoScaffale(String codiceArt,String codiceSc){

    }

    public void updateProdottoScaffale(ProdottoScaffale ps){

    }

    /**
     *
     * @param id riferito al prodotto che si vuole ricercare
     * @return l'oggetto Prodotto relativo alla ricerca tramite id
     */
    public Prodotto ricercaIdP(String id){

    }

    /**
     *
     * @param id riferito allo scaffale che si vuole ricercare
     * @return l'oggetto Scaffale relativo alla ricerca tramite id
     */
    public Scaffale ricercaIdS(int id){

    }

    /**
     *
     * @param id riferito al Magazzino che si vuole ricercare
     * @return l'oggetto Magazzino relativo alla ricerca tramite id
     */
    public Magazzino ricercaIdM(int id){

    }

    /**
     *
     * @param idP id relativo al prodotto che si trova sullo scaffale
     * @param idS id relativo allo scaffale
     * @return l'oggetto Prodottoscaffale relativo alla ricerca tramite i due id
     */
    public ProdottoScaffale ricercaIdPs(String idP,int idS){

    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Prodotto
     * @return una lista di oggetti Prodotto
     */
    public List<Prodotto> ricercaTuttiP(){

    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Scaffale
     * @return una lista di oggetti Scaffale
     */
    public List<Scaffale> ricercaTuttiS(){

    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Magazzino
     * @return una lista di oggetti Magazzino
     */
    public List<Magazzino> ricercaTuttiM(){

    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella ProdottoScaffale
     * @return una lista di oggetti ProdottoScaffale
     */
    public List<ProdottoScaffale> ricercaTuttiPs(){

    }
}
