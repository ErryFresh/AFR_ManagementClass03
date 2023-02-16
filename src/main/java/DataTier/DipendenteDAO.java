package DataTier;

import ENTITY.Calendario;
import ENTITY.Dipendente;
import ENTITY.EventoCalendario;
import ENTITY.Reparto;
import jakarta.inject.Singleton;

import java.net.ConnectException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Il seguente DAO incorpora Dipendente, Reparto, Calendario ed Evento, si occupa di effettuare query e aggiunta, rimozione, aggiornamenti
 * dei seguenti oggetti nel nostro database.
 */
@Singleton
public class DipendenteDAO {
    private DipendenteDAO(){}
    private static DipendenteDAO single_instance = null;
    /**
     * Essendo la classe DipendenteDAO caratterizzata dall'utilizzo del design pattern Singleton, quest'ultima non presenta alcun costruttore pubblico,
     * infatti non vi è modo d'inizializzare alcun oggetto al di fuori di esso, l'unico modo di accedervi è tramite suddetto metodo
     * @return un'istanza dell'oggetto DipendenteDAO per poter rendere accessibili i suoi metodi
     */
    public static DipendenteDAO getSingle_instance(){
        if(single_instance == null){
            synchronized (DipendenteDAO.class){
                if(single_instance ==  null)
                    single_instance = new DipendenteDAO();
            }
        }

        return single_instance;
    }

    /**
     * Il metodo ci permette di aggiungere un nuovo dipendente al database.
     * @param d Dipendete da salvare all'interno del database.
     */
    public void addDipendenti(Dipendente d){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO dipendente (matricola,password,cf,nome,cognome,recapito,eMail,posizione,codiceRep) VALUES(?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, d.getMatricola());
            ps.setString(2, d.getPassword());
            ps.setString(3, d.getCf());
            ps.setString(4, d.getNome());
            ps.setString(5, d.getCognome());
            ps.setString(6, d.getRecapito());
            ps.setString(7, d.getEmail());
            ps.setString(8, d.getPosizione());
            ps.setInt(9, d.getCodiceRep());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException e){
                throw new RuntimeException(e);
        }
    }

    /**
     *  Il metodo ci permette di rimuovere un dipendente da dentro al database
     * @param matricola ci permette di trovare il dipendente da eliminare.
     */
    public void removeDipendente(String matricola){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM dipendente WHERE matricola = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,matricola);
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("DELETE error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo ci permette di aggiornare un dipendente all'interno del database
     * @param d Dipendente da aggiornare all'interno del database.
     */
    public void updateDipendente(Dipendente d){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE dipendente SET password = ?,cf = ?,nome = ?,cognome = ?,recapito = ?,eMail = ?,posizione = ?,codiceRep = ? WHERE matricola = ?");
            ps.setString(1, d.getPassword());
            ps.setString(2,d.getCf());
            ps.setString(3,d.getNome());
            ps.setString(4,d.getCognome());
            ps.setString(5,d.getRecapito());
            ps.setString(6,d.getEmail());
            ps.setString(7,d.getPosizione());
            ps.setInt(8,d.getCodiceRep());
            ps.setString(9,d.getMatricola());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo aggiunge una nuova istanza di Reparto al database
     * @param r Reparto da aggiungere al database
     */
    public void addReparto(Reparto r){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO reparto (codiceRep,nome,descrizione) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, r.getCodiceReparto());
            ps.setString(2, r.getNome());
            ps.setString(3, r.getDescrizione());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    /**
     * Il metodo rimuove un istanza di Reparto all'interno del database
     * @param codiceRep ci permette di trovare il reparto da eliminare
     */
    public void removeReparto(int codiceRep){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM reparto WHERE codiceRep = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,codiceRep);
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("DELETE error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Il metodo si occupa di aggiornare un istanza di Reparto nel database
     * @param r nuove informazioni del Reparto da aggiornare
     */
    public void updateReparto(Reparto r){
       try(Connection con = ConPool.getConnection()){
           PreparedStatement ps = con.prepareStatement("UPDATE reparto SET nome = ?,descrizione = ? WHERE codiceRep = ?");
           ps.setString(1,r.getNome());
           ps.setString(2,r.getDescrizione());
           ps.setInt(3,r.getCodiceReparto());
           ps.executeUpdate();
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    /**
     *Il metodo permette l'aggiunta d'istanze Calendario al database
     * @param c Calendario da aggiungere al database
     */
    public void addCalendario(Calendario c){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO calendario(codiceCal,nome,codiceRep,matricolaDip) VALUES (?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,c.getCodiceCal());
            ps.setString(2,c.getNome());
            ps.setInt(3,c.getCodiceRep());
            ps.setString(4,c.getMatricola());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Il metodo ci permette la rimozione di un istanza Calendario nel database
     * @param codiceCal stringa che utilizziamo per cercare il calendario da rimuovere
     */
    public void removeCalendario(String codiceCal){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM calendario WHERE codiceCal = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,codiceCal);
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("DELETE error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Il metodo aggiorna un istanza di Calendario nel database
     * @param c Oggetto calendario da cui prendiamo tutte le informazioni da aggiornare
     */
    public void updateCalendario(Calendario c){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE calendario SET nome = ?,codiceRep = ?,matricolaDip = ? WHERE codiceCal = ? ");
            ps.setString(1,c.getNome());
            ps.setInt(2,c.getCodiceRep());
            ps.setString(3,c.getMatricola());
            ps.setString(4,c.getCodiceCal());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo ci permette di aggiungere istanze nel database
     * @param e Evento da aggiungere nel database
     */
    public void addEvento(EventoCalendario e){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("INSERT INTO evento(codiceEv,nome,descrizione,dataEv,matricolaDip,codiceCal) VALUES (?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,e.getCodiceEvento());
            ps.setString(2,e.getNome());
            ps.setString(3,e.getDescrizione());
            ps.setString(4, (String) e.getData());
            ps.setString(5,e.getMatricola());
            ps.setString(6,e.getCodiceCal());
            if (ps.executeUpdate() != 1) {
                throw new RuntimeException("INSERT error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        }catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Il metodo elimina un istanza Evento dal database
     * @param codiceEv ci permette di trovare l'evento che vogliamo eliminare tramite l'identificatore
     */
    public static void removeEvento(String codiceEv){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM evento WHERE codiceEv = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,codiceEv);
            if(ps.executeUpdate() != 1){
                throw new RuntimeException("DELETE error.");
            }
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateEvento(EventoCalendario e){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE evento SET nome = ?,descrizione = ?,dataEv = ?,matricolaDip = ?,codiceCal = ? WHERE codiceEv = ? ");
            ps.setString(1,e.getNome());
            ps.setString(2,e.getDescrizione());
            ps.setString(3, (String) e.getData());
            ps.setString(4,e.getMatricola());
            ps.setString(5,e.getCodiceCal());
            ps.setString(6,e.getCodiceEvento());
            ps.executeUpdate();
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }


    //query ricerca per id

    /**
     *Il metodo permette la ricerca di un Dipendete tramite la matricola
     * @param id riferito al dipendente da ricercare
     * @return l'oggetto Dipendente relativo all'id ricercato
     */
    public Dipendente ricercaIdD(String id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM dipendente WHERE matricola = ?");
            ps.setString(1, id);
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
     * Il metodo ci permette di ricercare un dipendente utilizzando la matricola e
     * ritornarlo senza la password quale dato sensibile
     * @param id utile nella ricerca del dipendente nel database
     * @return dipendente senza il parametro password
     */
    public Dipendente rimuoviPSW(String id) {
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM dipendente WHERE matricola = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Dipendente d = new Dipendente();
                d.setMatricola(rs.getString(1));
                d.setPassword("TOP SECRET");
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
     *Il metodo ci permette di trovare un Reparto tramite il codiceRep
     * @param id riferito al reparto da ricercare
     * @return l'oggetto Reparto relativo all'id ricercato
     */
    public Reparto ricercaIdR(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM reparto WHERE codiceRep = ?");
            ps.setInt(1,id);
            ResultSet rs =ps.executeQuery();
            if(rs.next()){
                Reparto r = new Reparto();
                r.setCodiceReparto(rs.getInt(1));
                r.setNome(rs.getString(2));
                r.setDescrizione(rs.getString(3));

                return r;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /***
     *Il metodo ricerca un istanza Calendario in base all'id inserito
     * @param id riferito al reparto da ricercare
     * @return l'oggetto Calendario relativo all'id ricercato
     */
    public Calendario ricercaIdC(String id){
       try(Connection con = ConPool.getConnection()){
           PreparedStatement ps = con.prepareStatement("SELECT * FROM calendario WHERE codiceCal = ?");
           ps.setString(1, id);
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               Calendario c = new Calendario();
               c.setCodiceCal(rs.getString(1));
               c.setNome(rs.getString(2));
               c.setCodiceRep(rs.getInt(3));
               c.setMatricola(rs.getString(4));

               return c;
           }
           return null;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    /***
     *Il metodo restituisce un istanza Evento
     * @param id riferito al reparto da ricercare
     * @return l'oggetto Evento relativo all'id ricercato
     */
    public EventoCalendario ricercaIdE(String id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM evento WHERE codiceEv = ?");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                EventoCalendario e = new EventoCalendario();
                e.setCodiceEvento(rs.getString(1));
                e.setNome(rs.getString(2));
                e.setDescrizione(rs.getString(3));
                e.setData(rs.getString(4));
                e.setMatricola(rs.getString(5));
                e.setCodiceCal(rs.getString(6));

                return e;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Dipendente
     * @return una lista di oggetti Dipendente rimuovendo però il valore della password associata
     */
    public List<Dipendente> ricercaTuttiD() {
        try (Connection con = ConPool.getConnection()) {
            ArrayList<Dipendente> list = new ArrayList<Dipendente>();
            PreparedStatement ps = con.prepareStatement("SELECT matricola FROM dipendente");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Dipendente d = DipendenteDAO.getSingle_instance().rimuoviPSW(rs.getString(1));
                list.add(d);
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Reparto
     * @return una lista di oggetti Reparto
     */
    public List<Reparto> ricercaTuttiR(){
       try(Connection con = ConPool.getConnection()){
           ArrayList<Reparto> list = new ArrayList<Reparto>();
           PreparedStatement ps = con.prepareStatement("SELECT codiceRep FROM reparto");
           ResultSet rs = ps.executeQuery();
           while (rs.next()){
               list.add(DipendenteDAO.getSingle_instance().ricercaIdR(rs.getInt(1)));
           }
           return list;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Calendario
     * @return una lista di oggetti Calendario
     */
    public List<Calendario> ricercaTuttiC(){
       try(Connection con = ConPool.getConnection()){
           ArrayList<Calendario> list = new ArrayList<Calendario>();
           PreparedStatement ps = con.prepareStatement("SELECT codiceCal FROM calendario");
           ResultSet rs = ps.executeQuery();
           while(rs.next()){
               list.add(DipendenteDAO.getSingle_instance().ricercaIdC(rs.getString(1)));
           }
           return list;
       } catch (SQLException e) {
           throw new RuntimeException(e);
       }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Evento
     * @return una lista di oggetti Evento
     */
    public List<EventoCalendario> ricercaTuttiE(){
        try(Connection con = ConPool.getConnection()){
            ArrayList<EventoCalendario> list = new ArrayList<EventoCalendario>();
            PreparedStatement ps = con.prepareStatement("SELECT codiceEv FROM evento");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(DipendenteDAO.getSingle_instance().ricercaIdE(rs.getString(1)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricavare il calendario a partire dal reparto
     * @param id riferito al reparto da utilizzare per la ricerca
     * @return calendario relativo al reparto
     */
    public Calendario ricercaRepC(int id) {
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM calendario WHERE codiceRep = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Calendario c = new Calendario();
                c.setCodiceCal(rs.getString(1));
                c.setNome(rs.getString(2));
                c.setCodiceRep(rs.getInt(3));
                c.setMatricola(rs.getString(4));

                return c;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
