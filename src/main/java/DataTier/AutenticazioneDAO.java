package DataTier;

import ENTITY.Dipendente;
import jakarta.inject.Singleton;

import java.sql.*;


/**
 * Classe che permette di effettuare l'autenticazione dell'utente e inserimento all'interno del database dell'utente appena registrato
 */
@Singleton
public class AutenticazioneDAO {

    private static AutenticazioneDAO single_instance = null;

    private AutenticazioneDAO(){}
    /**
     * Essendo la classe AutenticazioneDAO caratterizzata dall'utilizzo del design pattern Singleton, quest'ultima non presenta alcun costruttore pubblico,
     * infatti non vi è modo d'inizializzare alcun oggetto al di fuori di esso, l'unico modo di accedervi è tramite suddetto metodo
     * @return un'istanza dell'oggetto AutenticazioneDAO per poter rendere accessibili i suoi metodi
     */
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
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM dipendente WHERE password = ? AND eMail = ?");
            ps.setString(1, psw);
            ps.setString(2, eMail);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Dipendente d = new Dipendente();
                d.setMatricola(rs.getString(1));
                d.setPassword(rs.getString(2));
                d.setCf(rs.getString(3));
                d.setNome(rs.getString(4));
                d.setCognome(rs.getString(5));
                d.setRecapito(rs.getString(6));
                d.setEmail(rs.getString(7));
                d.setPosizione(rs.getString(8));
                d.setCodiceRep(rs.getInt(9));

                return d;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *
     * @param d Dipendente appena creato dal sistema con i dati parzialmente inseriti dall'utente e la password generata dal sistema;
     */
    public void addDipendente(Dipendente d) {
        DipendenteDAO.getInstance().addDipendenti(d);
    }
}
