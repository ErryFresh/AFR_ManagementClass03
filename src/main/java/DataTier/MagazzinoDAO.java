package DataTier;

import ENTITY.*;
import jakarta.inject.Singleton;

import java.sql.*;
import java.util.ArrayList;
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
     *Il metodo ci permette di aggiungere un magazzino al database
     * @param m Magazzino da aggiungere al database
     */
    public void addMagazzino(Magazzino m){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO magazzino (codiceMag,indirizzo,nScaffali) VALUES(?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,m.getCodiceMagazzino());
            ps.setString(2,m.getIndirizzo());
            ps.setInt(3,m.getnScaffali());
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
     * Il metodo ci permette di rimuovere un Magazzino al database
     * @param codiceMag identificatore per trovare il Magazzino da rimuovere
     */
    public void removeMagazzino(int codiceMag){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM magazzino WHERE codiceMag = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,codiceMag);
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
     * Il metodo permette l'aggiornamento di un istanza Magazzino nel database
     * @param m trasporta le nuove informazioni da inserire nel database
     */
    public void updateMagazzino(Magazzino m){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE magazzino SET indirizzo = ?,nScaffali = ? WHERE codiceMag = ?");
            ps.setString(1,m.getIndirizzo());
            ps.setInt(2,m.getnScaffali());
            ps.setInt(3,m.getCodiceMagazzino());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo permette l'aggiunta di un istanza Prodotto nel database
     * @param p Prodotto da aggiungere nel database
     */
    public void addProdotto(Prodotto p){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO prodotto (codiceArt,nome,descrizione,prezzoAcquisto,prezzoVendita,tipologiaVendita) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,p.getCodiceArt());
            ps.setString(2,p.getNome());
            ps.setString(3,p.getDescrizione());
            ps.setDouble(4,p.getPrezzoAcquisto());
            ps.setDouble(5,p.getPrezzoVendita());
            ps.setString(6,p.getTipologiaVendita());
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
     * Il metodo permette la rimozione di un istanza Prodotto nel database
     * @param codiceArt identificatore del Prodotto da eliminare
     */
    public void removeProdotto(String codiceArt){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM prodotto WHERE codiceArt = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,codiceArt);
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
     * Il metodo permette l'aggiornamento di un prodotto nel database
     * @param p trasporta le informazioni da modificare
     */
    public void updateProdotto(Prodotto p){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE prodotto SET nome = ?,descrizione = ?,prezzoAcquisto = ?,prezzoVendita = ?,tipologiaVendita = ? WHERE codiceArt = ?");
            ps.setString(1,p.getNome());
            ps.setString(2,p.getDescrizione());
            ps.setDouble(3,p.getPrezzoAcquisto());
            ps.setDouble(4,p.getPrezzoVendita());
            ps.setString(5,p.getTipologiaVendita());
            ps.setString(6,p.getCodiceArt());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo ci permette di aggiungere un istanza Scaffale al database
     * @param s Scaffale da aggiungere nel database
     */

    public void addScaffale(Scaffale s){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO scaffale (codicSc,nome,descrizione,superficweOccupata,superficeDisponibile,codiceMag) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,s.getCodiceScaffale());
            ps.setString(2,s.getNome());
            ps.setString(3,s.getDescrizione());
            ps.setDouble(4,s.getSurOccupata());
            ps.setDouble(5,s.getSurDisponibile());
            ps.setInt(6,s.getCodiceMagazzino());
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
     * Metoodo che permette la rimozione di un istanza Scaffale dal database
     * @param codiceSc identificativo dello scaffale
     */
    public void removeScaffale(int codiceSc){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM scaffale WHERE codiceSc = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,codiceSc);
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
     * Metodo che permette l'aggiornamento di un istanza Scaffale del database
     * @param s istanza da aggiornare
     */
    public void updateScaffale(Scaffale s){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE scaffale SET nome = ?,descrizione = ?,superficeOccupata = ?,superficeDisponibile = ?,codiceMag = ? WHERE codiceSc = ?");
            ps.setString(1,s.getNome());
            ps.setString(2,s.getDescrizione());
            ps.setDouble(3,s.getSurOccupata());
            ps.setDouble(4,s.getSurDisponibile());
            ps.setInt(5,s.getCodiceMagazzino());
            ps.setInt(6,s.getCodiceScaffale());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo permette di aggiungere un istanza ProdottoScaffale sul database
     * @param pS ProdottoScaffale da aggiungere nel database
     */
    public void addProdottoScaffale(ProdottoScaffale pS){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO prodottoscaffale (codiceArt,codiceSc,quantita,lunghezza,larghezza,altezza) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,pS.getCodiceArt());
            ps.setInt(2,pS.getCodiceScaffale());
            ps.setInt(3,pS.getQta());
            ps.setDouble(4,pS.getLunghezza());
            ps.setDouble(5,pS.getLarghezza());
            ps.setDouble(6,pS.getAltezza());
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
     * Il metodo permette di rimuovere un istanza ProdottoScaffale dal database
     * @param codiceArt identificatore utile alla ricerca dell'istanza da eliminare
     * @param codiceSc identificatore utile alla ricerca dell'istanza da eliminare
     */
    public void removeProdottoScaffale(String codiceArt,int codiceSc){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement(
                    "DELETE FROM prodottoscaffale WHERE codiceArt = ? AND codiceSc = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,codiceArt);
            ps.setInt(2,codiceSc);
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
     * Metodo che permette l'aggiornamento di un istanza ProdottoScaffale sul database
     * @param pS istanza contenente le informazioni per l'aggiornamento
     */
    public void updateProdottoScaffale(ProdottoScaffale pS){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE prodottoscaffale SET quantita = ?,lunghezza = ?,largehzza = ?,altezza = ? WHERE codiceArt = ? AND codiceSc = ?");
            ps.setInt(1,pS.getQta());
            ps.setDouble(2,pS.getLunghezza());
            ps.setDouble(3,pS.getLarghezza());
            ps.setDouble(4,pS.getAltezza());
            ps.setString(5,pS.getCodiceArt());
            ps.setInt(6,pS.getCodiceScaffale());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo ricerca una determinata istanza Prodotto nel database
     * @param id riferito al prodotto che si vuole ricercare
     * @return l'oggetto Prodotto relativo alla ricerca tramite id
     */
    public static Prodotto ricercaIdP(String id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM Prodotto WHERE codiceArt = ?");
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Prodotto p = new Prodotto();
                p.setCodiceArt(rs.getString(1));
                p.setNome(rs.getString(2));
                p.setDescrizione(rs.getString(3));
                p.setPrezzoAcquisto(rs.getDouble(4));
                p.setPrezzoVendita(rs.getDouble(5));
                p.setTipologiaVendita(rs.getString(6));
                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo ricerca una determinata istanza Scaffale nel database
     * @param id riferito allo scaffale che si vuole ricercare
     * @return l'oggetto Scaffale relativo alla ricerca tramite id
     */
    public static Scaffale ricercaIdS(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM scaffale WHERE codiceSc = ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                Scaffale s = new Scaffale();
                s.setCodiceScaffale(rs.getInt(1));
                s.setNome(rs.getString(2));
                s.setDescrizione(rs.getString(3));
                s.setSurOccupata(rs.getDouble(4));
                s.setSurDisponibile(rs.getDouble(5));
                s.setCodiceMagazzino(rs.getInt(6));
                return s;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo ricerca una determinata istanza Magazzino nel database
     * @param id riferito al Magazzino che si vuole ricercare
     * @return l'oggetto Magazzino relativo alla ricerca tramite id
     */
    public static Magazzino ricercaIdM(int id){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM magazzino WHERE codiceMag= ?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
               Magazzino m = new Magazzino();
               m.setCodiceMagazzino(rs.getInt(1));
               m.setIndirizzo(rs.getString(2));
               m.setnScaffali(rs.getInt(3));
                return m;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo ricerca una determinata istanza prodottoScaffale nel database
     * @param idP id relativo al prodotto che si trova sullo scaffale
     * @param idS id relativo allo scaffale
     * @return l'oggetto Prodottoscaffale relativo alla ricerca tramite i due id
     */
    public static ProdottoScaffale ricercaIdPs(String idP,int idS){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement("SELECT * FROM prodottoscaffale WHERE codiceArt = ? AND codiceSc = ?");
            ps.setString(1, idP);
            ps.setInt(2,idS);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                ProdottoScaffale pS = new ProdottoScaffale();
                pS.setCodiceArt(rs.getString(1));
                pS.setCodiceScaffale(rs.getInt(2));
                pS.setQta(rs.getInt(3));
                pS.setLunghezza(rs.getDouble(4));
                pS.setLarghezza(rs.getDouble(5));
                pS.setAltezza(rs.getDouble(6));
                return pS;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Prodotto
     * @return una lista di oggetti Prodotto
     */
    public List<Prodotto> ricercaTuttiP(){
        try(Connection con = ConPool.getConnection()){
            ArrayList<Prodotto> list = new ArrayList<Prodotto>();
            PreparedStatement ps = con.prepareStatement("SELECT codiceArt FROM prodotto");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(MagazzinoDAO.ricercaIdP(rs.getString(1)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Scaffale
     * @return una lista di oggetti Scaffale
     */
    public List<Scaffale> ricercaTuttiS(){
        try(Connection con = ConPool.getConnection()){
            ArrayList<Scaffale> list = new ArrayList<Scaffale>();
            PreparedStatement ps = con.prepareStatement("SELECT codiceSc FROM scaffale");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(ricercaIdS(rs.getInt(1)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Magazzino
     * @return una lista di oggetti Magazzino
     */
    public List<Magazzino> ricercaTuttiM(){
        try(Connection con = ConPool.getConnection()){
            ArrayList<Magazzino> list = new ArrayList<Magazzino>();
            PreparedStatement ps = con.prepareStatement("SELECT codiceMag FROM magazzino");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(MagazzinoDAO.ricercaIdM(rs.getInt(1)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella ProdottoScaffale
     * @return una lista di oggetti ProdottoScaffale
     */
    public List<ProdottoScaffale> ricercaTuttiPs(){
        try(Connection con = ConPool.getConnection()){
            ArrayList<ProdottoScaffale> list = new ArrayList<ProdottoScaffale>();
            PreparedStatement ps = con.prepareStatement("SELECT codiceArt AND codiceSc FROM evento");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(MagazzinoDAO.ricercaIdPs(rs.getString(1),rs.getInt(2)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
