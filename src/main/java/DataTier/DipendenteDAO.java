package DataTier;

import Entity.Calendario;
import Entity.Dipendente;
import Entity.Evento;
import Entity.Reparto;

import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Il seguente DAO incorpora Dipendente, Reparto, Calendario ed Evento, si occupa di effettuare query e aggiunta, rimozione, aggiornamenti
 * dei seguenti oggetti nel nostro database.
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
public class DipendenteDAO {
    @Inject
    private EntityManager em;

    private DipendenteDAO(){}
    private static DipendenteDAO single_instance = null;
    public static DipendenteDAO getInstance(){
        if(single_instance == null){
            synchronized (DipendenteDAO.class){
                if(single_instance ==  null)
                    single_instance = new DipendenteDAO();
            }
        }

        return single_instance;
    }

    /**
     *
     * @param d Dipendente su cui effettuare i metodi di aggiunta, rimozione e aggiornamento nel database
     */
    public void addDipendenti(Dipendente d){
        em.persist(d);
    }

    public void removeDipendente(Dipendente d){
        em.remove(em.merge(d));
    }

    public Dipendente updateDipendente(Dipendente d){
        return em.merge(d);
    }

    /**
     *
     * @param r Reparto su cui effettuare i metodi di aggiunta, rimozione e aggiornamento nel database
     */
    public void addReparto(Reparto r){
        em.persist(r);
    }

    public void removeReparto(Reparto r){
        em.remove(em.merge(r));
    }

    public Reparto updateReparto(Reparto r){
        return em.merge(r);
    }

    /**
     *
     * @param c Calendario su cui effettuare i metodi di aggiunta, rimozione e aggiornamento nel database
     */
    public void addCalendario(Calendario c){
        em.persist(c);
    }

    public void removeCalendario(Calendario c){
        em.remove(em.merge(c));
    }

    public Calendario updateCalendario(Calendario c){
        return em.merge(c);
    }

    /**
     *
     * @param e Evento su cui effettuare i vari metodi di aggiunta, rimozione e aggiornamento nel database
     */
    public void addEvento(Evento e){
        em.persist(e);
    }

    public void removeEvento(Evento e){
        em.remove(em.merge(e));
    }

    public Evento updateEvento(Evento e){
        return em.merge(e);
    }


    //query ricerca per id

    /**
     *
     * @param id riferito al dipendente da ricercare
     * @return l'oggetto Dipendente relativo all'id ricercato
     */
    public Dipendente ricercaIdD(String id){
        Query q = em.createQuery("SELECT d FROM Dipendente d WHERE d.matricola = :id",Dipendente.class);
        q.setParameter("id", id);
        return (Dipendente) q.getSingleResult();
    }

    /**
     *
     * @param id riferito al reparto da ricercare
     * @return l'oggetto Reparto relativo all'id ricercato
     */
    public Reparto ricercaIdR(int id){
        Query q = em.createQuery("SELECT r FROM Reparto r WHERE r.codiceRep = :id", Reparto.class);
        q.setParameter("id", id);
        return (Reparto) q.getSingleResult();
    }

    /***
     *
     * @param id riferito al reparto da ricercare
     * @return l'oggetto Calendario relativo all'id ricercato
     */
    public Calendario ricercaIdC(String id){
        Query q = em.createQuery("SELECT c FROM Calendario c WHERE c.codiceCal = :id",Calendario.class);
        q.setParameter("id", id);
        return (Calendario) q.getSingleResult();
    }

    /***
     *
     * @param id riferito al reparto da ricercare
     * @return l'oggetto Evento relativo all'id ricercato
     */
    public Evento ricercaIdE(String id){
        Query q = em.createQuery("SELECT e FROM Evento e WHERE e.codiceEv = : id", Evento.class);
        q.setParameter("id", id);
        return (Evento) q.getSingleResult();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Dipendente
     * @return una lista di oggetti Dipendente rimuovendo però il valore della password associata
     */
    public List<Dipendente> ricercaTuttiD(){
        Query q = em.createQuery("SELECT d FROM Dipendente d",Dipendente.class);
        List<Dipendente> list = q.getResultList();

        for(int i=0;i<list.size();i++){
            list.get(i).setPassword("");
        }
        return list;
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Reparto
     * @return una lista di oggetti Reparto
     */
    public List<Reparto> ricercaTuttiR(){
        Query q = em.createQuery("SELECT r FROM Reparto r",Reparto.class);
        return q.getResultList();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Calendario
     * @return una lista di oggetti Calendario
     */
    public List<Calendario> ricercaTuttiC(){
        Query q = em.createQuery("SELECT c FROM Calendario c", Calendario.class);
        return q.getResultList();
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Evento
     * @return una lista di oggetti Evento
     */
    public List<Evento> ricercaTuttiE(){
        Query q = em.createQuery("SELECT e FROM Evento e",Evento.class);
        return q.getResultList();
    }



}
