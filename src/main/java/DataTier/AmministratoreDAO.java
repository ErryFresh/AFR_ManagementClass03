package DataTier;

import Entity.*;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

/**
 * Il seguente DAO incorpora Pagamento, Documento, ProdottoDocumento ed ClienteFornitore, si occupa di effettuare query e aggiunta, rimozione, aggiornamenti
 *  * dei seguenti oggetti nel nostro database.
 */
@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/afr_management",
        user ="root", password = "Pisch3ll0!!MySQL",
        databaseName = "afr_management",
        properties = {"connectionAttribute=;create=true"}
)
public class AmministratoreDAO {
    @Inject
    private EntityManager em;

    private static AmministratoreDAO single_instance = null;

    private AmministratoreDAO(){
    }

    public static AmministratoreDAO getSingle_instance(){
        if(single_instance ==  null){
            synchronized (AmministratoreDAO.class){
                if(single_instance ==  null)
                    single_instance = new AmministratoreDAO();
            }
        }
        return single_instance;
    }

    /**
     *
     * @param p Pagamento su cui effettuare i vari metodi di aggiunta, rimozione e aggiornamento nel database
     */
    public void addPagamento(Pagamento p){
        em.persist(p);
    }

    public void removePagamento(Pagamento p){
        em.remove(em.merge(p));
    }

    public Pagamento updatePagamento(Pagamento p){
        return em.merge(p);
    }

    /**
     *
     * @param d Documento su cui effettuare i vari metodi di aggiunta, rimozione e aggiornamento nel database
     */
    public void addDocumento(Documento d){
        em.persist(d);
    }

    public void removeDocumento(Documento d){
        em.remove(em.merge(d));
    }

    public Documento updateDocumento(Documento d){
        return em.merge(d);
    }

    /**
     *
     * @param pd ProdottoDocumento su cui effettuare i vari metodi di aggiunta, rimozione e aggiornamento nel database
     */
    public void addProdottoDocumento(Prodottodocumento pd){
        em.persist(pd);
    }

    public void removeProdottoDocumento(Prodottodocumento pd){
        em.remove(em.merge(pd));
    }

    public Prodottodocumento updateProdottoDocumento(Prodottodocumento pd){
        return em.merge(pd);
    }

    /**
     *
     * @param cf ClienteFornitore su cui effettuare i vari metodi di aggiunta, rimozione e aggiornamento nel database
     */
    public void addClienteFornitore(Clientefornitore cf){
        em.persist(cf);
    }

    public void removeClienteFornitore(Clientefornitore cf){
        em.remove(em.merge(cf));
    }

    public Clientefornitore updateClienteFornitore(Clientefornitore cf){
        return em.merge(cf);
    }


    /**
     *
     * @param id riferito al Pagamento da ricercare
     * @return l'oggetto Pagamento relativo all'id ricercato
     */
    public Pagamento ricercaIdP(int id){
        Query q = em.createQuery("SELECT p FROM Pagamento p WHERE p.nTransazione = :id", Pagamento.class);
        q.setParameter("id", id);
        return (Pagamento) q.getSingleResult();
    }

    /**
     *
     * @param id riferimento al Documento da ricercare
     * @return l'oggetto Documento relativo all'id ricercato
     */
    public Documento ricercaIdD(String id){
        Query q = em.createQuery("SELECT d  FROM Documento d WHERE d.nDocumento = :id",Documento.class);
        q.setParameter("id", id);
        return (Documento) q.getSingleResult();
    }

    /**
     *
     * @param id riferimento al Prodottodocumento da ricercare
     * @return l'oggetto Prodottodocumento relativo all'id ricercato
     */
    public Prodottodocumento ricercaIdPd(String id){
        Query q = em.createQuery("SELECT pd FROM Prodottodocumento pd WHERE pd.codiceArt = :id", Prodottodocumento.class); //questa tabella ha 2 chiavi primarie, potrebbero essere fatte 3 qery con le varie combinazioni
        q.setParameter("id", id);
        return (Prodottodocumento) q.getSingleResult();
    }

    /**
     *
     * @param id riferimento al Prodottodocumento da ricercare
     * @return l'oggetto ClienteFornitore relativo all'id ricercato
     */
    public Clientefornitore ricercaIdCf(String id){
        Query q = em.createQuery("SELECT cf FROM Clientefornitore cf WHERE cf.cf = :id", Clientefornitore.class);
        q.setParameter("id", id);
        return (Clientefornitore) q.getSingleResult();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Pagamento
     * @return una lista di oggetti Pagamento
     */
    public List<Pagamento> ricercaTuttiP(){
        Query q = em.createQuery("SELECT p FROM Pagamento p");
        return q.getResultList();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Documento
     * @return una lista di oggetti Documento
     */
    public List<Documento> ricercaTuttiDo(){
        Query q = em.createQuery("SELECT d FROM Documento d");
        return q.getResultList();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Prodottodocumento
     * @return una lista di oggetti Prodottodocumento
     */
    public List<Prodottodocumento> ricercaTuttiPd(){
        Query q = em.createQuery("SELECT pd FROM Prodottodocumento pd");
        return q.getResultList();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Clientefornitore
     * @return una lista di oggetti Clientefornitore
     */
    public List<Clientefornitore> ricercaTuttiCf(){
        Query q = em.createQuery("SELECT cf FROM Clientefornitore cf");
        return  q.getResultList();
    }

    public List<Clientefornitore> ricercaTuttiCf(boolean scelta) {
        List<Clientefornitore> lista = ricercaTuttiCf();

        List<Clientefornitore> toReturn = new ArrayList<Clientefornitore>();

        int size = scelta?16:11;

        for(Clientefornitore c:lista){
            if(c.getCf().length()==size)
                toReturn.add(c);
        }

        return  toReturn;
    }
}
