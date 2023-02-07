package DataTier;

import ENTITY.Dipendente;
import jakarta.inject.Singleton;


/**
 * Classe che permette di effettuare l'autenticazione dell'utente e inserimento all'interno del database dell'utente appena registrato
 */
@Singleton
public class AutenticazioneDAO {

    private static AutenticazioneDAO single_instance = null;

    private AutenticazioneDAO(){}

    public static AutenticazioneDAO getSingle_instance() {
        if (single_instance == null)
            synchronized (AutenticazioneDAO.class){
                if(single_instance ==  null)
                    single_instance = new AutenticazioneDAO();
            }

        return single_instance;
    }

    /**
     *
     * @param psw password del dipendente che sta effettuando l'accesso
     * @param eMail eMail del dipendente che sta effettuando l'accesso
     * @return l'oggetto Dipendente corrispondente alla combinazione eMail e psw inseriti dall'utente
     */
    public Dipendente logIn(String psw, String eMail){
        Query q =em.createQuery("SELECT d FROM Dipendente d WHERE d.eMail = :email AND d.password = :psw");
        q.setParameter("email",eMail);
        q.setParameter("psw",psw);
        return (Dipendente) q.getSingleResult();
    }

    /**
     *
     * @param d Dipendente appena creato dal sistema con i dati parzialmente inseriti dall'utente e la password generata dal sistema;
     */
    public void addDipendente(Dipendente d){em.persist(d);}
}
