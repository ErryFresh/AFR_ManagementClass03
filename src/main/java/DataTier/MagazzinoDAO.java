package DataTier;

import Entity.*;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Il seguente DAO incorpora Magazzino,Prodotto,Scaffale,ProdottoScaffale, è possibile effettuare query relative all'aggiunta, modifica e cancellazione
 * degli oggetti all'interno del database
 */

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/Afr_Management",
        user = "root", password = "Pisch3ll0!!MySQL",
        databaseName = "afr_management",
        properties = {"connectionAttribute=;create=true"}
)
public class MagazzinoDAO {

    @Inject
    private EntityManager em;

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
        em.persist(m);
    }

    public void removeMagazzino(Magazzino m){
        em.persist(m);
    }

    public Magazzino updateMagazzino(Magazzino m){
        return em.merge(m);
    }

    /**
     *
     * @param p Prodotto su cui effettuare aggiunta, rimozione e aggiornamento del database
     */
    public void addProdotto(Prodotto p){
        em.persist(p);
    }

    public void removeProdotto(Prodotto p){
        em.persist(p);
    }

    public Prodotto updateProdotto(Prodotto p){
        return em.merge(p);
    }

    /**
     *
     * @param s Scaffale su cui effettuare aggiunta, rimozione e aggiornamento del database
     */

    public void addScaffale(Scaffale s){
        em.persist(s);
    }

    public void removeScaffale(Scaffale s){
        em.persist(s);
    }

    public Scaffale updateScaffale(Scaffale s){
        return em.merge(s);
    }

    /**
     *
     * @param ps ProdottoScaffale su cui effettuare aggiunta, rimozione e aggiornamento del database
     */
    public void addProdottoScaffale(Prodottoscaffale ps){
        em.persist(ps);
    }

    public void removeProdottoScaffale(Prodottoscaffale ps){
        em.persist(ps);
    }

    public Prodottoscaffale updateProdottoScaffale(Prodottoscaffale ps){
        return em.merge(ps);
    }

    /**
     *
     * @param id riferito al prodotto che si vuole ricercare
     * @return l'oggetto Prodotto relativo alla ricerca tramite id
     */
    public Prodotto ricercaIdP(String id){
        Query q = em.createQuery("SELECT p FROM Prodotto p WHERE p.codiceArt=:id",Prodotto.class);
        q.setParameter("id",id);
        return (Prodotto) q.getSingleResult();
    }

    /**
     *
     * @param id riferito allo scaffale che si vuole ricercare
     * @return l'oggetto Scaffale relativo alla ricerca tramite id
     */
    public Scaffale ricercaIdS(int id){
        Query q = em.createQuery("SELECT s FROM Scaffale s WHERE s.codiceSc=:id",Scaffale.class);
        q.setParameter("id",id);
        return (Scaffale) q.getSingleResult();
    }

    /**
     *
     * @param id riferito al Magazzino che si vuole ricercare
     * @return l'oggetto Magazzino relativo alla ricerca tramite id
     */
    public Magazzino ricercaIdM(int id){
        Query q = em.createQuery("SELECT m FROM Magazzino m WHERE m.codiceMag=:id",Magazzino.class);
        q.setParameter("id",id);
        return (Magazzino) q.getSingleResult();
    }

    /**
     *
     * @param idP id relativo al prodotto che si trova sullo scaffale
     * @param idS id relativo allo scaffale
     * @return l'oggetto Prodottoscaffale relativo alla ricerca tramite i due id
     */
    public Prodottoscaffale ricercaIdPs(String idP,int idS){
        Query q = em.createQuery("SELECT ps FROM Prodottoscaffale ps WHERE ps.codiceArt=:idP and ps.codiceSc=:idS",Magazzino.class);
        q.setParameter("idP",idP);
        q.setParameter("idS",idS);
        return (Prodottoscaffale) q.getSingleResult();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Prodotto
     * @return una lista di oggetti Prodotto
     */
    public List<Prodotto> ricercaTuttiP(){
        Query q = em.createQuery("SELECT p FROM Prodotto p",Prodotto.class);
        return q.getResultList();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Scaffale
     * @return una lista di oggetti Scaffale
     */
    public List<Scaffale> ricercaTuttiS(){
        Query q = em.createQuery("SELECT s FROM Scaffale s",Scaffale.class);
        return q.getResultList();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Magazzino
     * @return una lista di oggetti Magazzino
     */
    public List<Magazzino> ricercaTuttiM(){
        Query q = em.createQuery("SELECT m FROM Magazzino m",Magazzino.class);
        return q.getResultList();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella ProdottoScaffale
     * @return una lista di oggetti ProdottoScaffale
     */
    public List<Prodottoscaffale> ricercaTuttiPs(){
        Query q = em.createQuery("SELECT ps FROM Prodottoscaffale ps",Prodottoscaffale.class);
        return q.getResultList();
    }
}
