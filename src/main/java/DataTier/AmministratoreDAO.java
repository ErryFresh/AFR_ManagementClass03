package DataTier;

import ENTITY.*;
import jakarta.inject.Singleton;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Il seguente DAO incorpora Pagamento, Documento, ProdottoDocumento ed ClienteFornitore, si occupa di effettuare query e aggiunta, rimozione, aggiornamenti
 *  * dei seguenti oggetti nel nostro database.
 */
@Singleton
public class AmministratoreDAO {
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
     *Il metodo ci permette di aggiungere un Pagamento nel database
     * @param p Pagamento da aggiungere nel database
     */
    public static void addPagamento(Pagamento p){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO pagamento (nTransazione,tipo,nAssegno,causale,importo,saldato,dataEmissione,dataScadenza,beneficiario,emittente) VALUES(?,?,?,?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, p.getnTransazione());
            ps.setString(2,p.getTipo());
            ps.setString(3, p.getnAssegno());
            ps.setString(4,p.getCausale());
            ps.setDouble(5,p.getImporto());
            ps.setBoolean(6,p.isSaldato());
            ps.setDate(7, (Date) p.getEmissione());
            ps.setDate(8, (Date) p.getScadenza());
            ps.setString(9,p.getBeneficiario());
            ps.setString(10,p.getEmittente());
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
     * Il metodo ci permette di rimuovere un istanza Pagamento dal database
     * @param nTransazione chiave primaria per identificare l'istanza da eliminare
     */
    public static void removePagamento(int  nTransazione){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM pagamento WHERE nTransazione = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,nTransazione);
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
     * Il metodo ci permette l'aggiornamento dell'istanza all'interno del database
     * @param p oggetto Pagamento utile al trasporto delle nuove informazioni
     */
    public static void updatePagamento(Pagamento p){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE pagamento SET tipo = ?,nAssegno = ?,causale = ?,importo = ?,saldato = ?,dataEmissione = ?,dataScadenza = ?,beneficiario = ?,emittente = ?  WHERE nTransazione = ?");
            ps.setString(1,p.getTipo());
            ps.setString(2,p.getnAssegno());
            ps.setString(3,p.getCausale());
            ps.setDouble(4,p.getImporto());
            ps.setBoolean(5,p.isSaldato());
            ps.setDate(6, (Date) p.getEmissione());
            ps.setDate(7, (Date) p.getScadenza());
            ps.setString(8,p.getBeneficiario());
            ps.setString(9,p.getEmittente());
            ps.setInt(10,p.getnTransazione());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo ci permette di aggiungere un documento al database
     * @param d Documento da aggiungere nel database
     */
    public static void addDocumento(Documento d){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO documento (nDocumento,tipo,dataEmissione,note,cf,matricola) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, d.getnDocumento());
            ps.setString(2,d.getTipo());
            ps.setDate(3, (Date) d.getEmissione());
            ps.setString(4,d.getNote());
            ps.setString(5,d.getCf());
            ps.setString(6,d.getMatricola());
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
     * Il metodo rimuove un documento dal database
     * @param nDocumento identificatore del documento da eliminare
     */
    public static void removeDocumento(String nDocumento){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM documento WHERE nDocumento = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,nDocumento);
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
     * Il metodo aggiorna il documento nel database
     * @param d trasporta le nuove informazioni del documento.
     */
    public static void updateDocumento(Documento d){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE documento SET tipo = ?,dataEmissione = ?,note = ?,cf = ?,matricola = ? WHERE nDocumento = ?");
            ps.setString(1,d.getTipo());
            ps.setDate(2, (Date) d.getEmissione());
            ps.setString(3,d.getNote());
            ps.setString(4,d.getCf());
            ps.setString(5,d.getMatricola());
            ps.setString(6, d.getnDocumento());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo si occupa di aggiungere un nuovo prodottoDocumento al database
     * @param pd ProdottoDocumento da aggiungere nel database
     */
    public static void addProdottoDocumento(ProdottoDocumento pd){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO Prodottodocumento (codiceArt,codiceDoc,quantita,lunghezza,larghezza,altezza) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, pd.getCodiceArt());
            ps.setString(2,pd.getCodiceDoc());
            ps.setInt(3, pd.getQta());
            ps.setDouble(4,pd.getLunghezza());
            ps.setDouble(5,pd.getLarghezza());
            ps.setDouble(6,pd.getAltezza());
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
     * Il metodo ci permette di rimuovere un istanza prodottoDocumento
     * @param codiceArt identificatore dell'istanza da rimuovere
     * @param codiceDoc identificatore dell'istanza da rimuovere
     */
    public static void removeProdottoDocumento(String codiceArt,String codiceDoc){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM Prodottodocumento WHERE codiceArt = ? AND codiceDoc = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,codiceArt);
            ps.setString(2,codiceDoc);
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
     * Il meotodo permette di aggiornare l'istanza prodottodocumento nel database
     * @param pd trasporta gli aggiornamenti dell'istanza
     */
    public static void updateProdottoDocumento(ProdottoDocumento pd){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE Prodottodocumento SET quantita = ?,lunghezza = ?,larghezza = ?,altezza = ? WHERE codiceArt = ? AND codiceDoc = ?");
            ps.setInt(1,pd.getQta());
            ps.setDouble(2, pd.getLunghezza());
            ps.setDouble(3,pd.getLarghezza());
            ps.setDouble(4,pd.getAltezza());
            ps.setString(5,pd.getCodiceArt());
            ps.setString(6, pd.getCodiceDoc());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo aggiunge un istanza ClienteFornitore nel database
     * @param cf ClienteFornitore da aggiungere nel database
     */
    public static void addClienteFornitore(ClienteFornitore cf){
        try (Connection con = ConPool.getConnection()) {
            PreparedStatement ps = con.prepareStatement(
                    "INSERT INTO ClienteFornitore (cf,nome,cognome,recapito,eMail) VALUES(?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cf.getCf());
            ps.setString(2,cf.getNome());
            ps.setString(3,cf.getCognome());
            ps.setString(4,cf.getRecapito());
            ps.setString(5,cf.getEmail());
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
     * Metodo per rimuovere un istanza ClienteFornitore dal database
     * @param cf identificatore dell'istanza
     */
    public static void removeClienteFornitore(String cf){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("DELETE FROM ClienteFornitore WHERE cf = ?",Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cf);
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
     * Metodo per aggiornare un istanza nel database
     * @param cf identificatore dell'istanza
     */
    public static void updateClienteFornitore(ClienteFornitore cf){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("UPDATE ClienteFornitore SET nome = ?,cognome = ?,recapito = ?,eMail = ? WHERE cf = ?");
            ps.setString(1,cf.getNome());
            ps.setString(2, cf.getCognome());
            ps.setString(3, cf.getRecapito());
            ps.setString(4,cf.getEmail());
            ps.setString(5,cf.getCf());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     *Metoodo per ricercare un istanza di Pagamento
     * @param id riferito al Pagamento da ricercare
     * @return l'oggetto Pagamento relativo all'id ricercato
     */
    public static Pagamento ricercaIdP(int id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM pagamento WHERE nTransazione = ?");
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Pagamento p = new Pagamento();
                p.setnTransazione(rs.getInt(1));
                p.setTipo(rs.getString(2));
                p.setnAssegno(rs.getString(3));
                p.setCausale(rs.getString(4));
                p.setImporto(rs.getDouble(5));
                p.setSaldato(rs.getBoolean(6));
                p.setEmissione(rs.getDate(7));
                p.setScadenza(rs.getDate(8));
                p.setBeneficiario(rs.getString(9));
                p.setEmittente(rs.getString(10));

                return p;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo permette la ricerca di un istanza Documento
     * @param id riferimento al Documento da ricercare
     * @return l'oggetto Documento relativo all'id ricercato
     */
    public static Documento ricercaIdD(String id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM documento WHERE nDocumento = ?");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Documento d = new Documento();
                d.setnDocumento(id);
                d.setTipo(rs.getString(2));
                d.setEmissione(rs.getDate(3));
                d.setNote(rs.getString(4));
                d.setCf(rs.getString(5));
                d.setMatricola(rs.getString(6));
                return d;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo permette la ricerca di un istanza Prodottodocumento
     * @param codiceArt riferimento al Prodottodocumento da ricercare
     * @param codiceDoc identificatore dell'istanza
     * @return l'oggetto Prodottodocumento relativo all'id ricercato
     */
    public static ProdottoDocumento ricercaIdPd(String codiceArt, String codiceDoc){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM prodottodocumento WHERE codiceArt = ? AND codiceDoc = ?");
            ps.setString(1,codiceArt);
            ps.setString(2,codiceDoc);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProdottoDocumento pd = new ProdottoDocumento();
                pd.setCodiceArt(codiceArt);
                pd.setCodiceDoc(codiceDoc);
                pd.setQta(rs.getInt(3));
                pd.setLunghezza(rs.getDouble(4));
                pd.setLarghezza(rs.getDouble(5));
                pd.setAltezza(rs.getDouble(6));
                return pd;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     *Il metodo permette la ricerca di un istanza Clientefornitore
     * @param id riferimento al Prodottodocumento da ricercare
     * @return l'oggetto ClienteFornitore relativo all'id ricercato
     */
    public static ClienteFornitore ricercaIdCf(String id){
        try(Connection con = ConPool.getConnection()){
            PreparedStatement ps = con.prepareStatement("SELECT * FROM clientefornitore WHERE cf = ?");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ClienteFornitore cf = new ClienteFornitore();
                cf.setCf(rs.getString(1));
                cf.setNome(rs.getString(2));
                cf.setCognome(rs.getString(3));
                cf.setRecapito(rs.getString(4));
                cf.setEmail(rs.getString(5));
                return cf;
            }
            return null;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Pagamento
     * @return una lista di oggetti Pagamento
     */
    public List<Pagamento> ricercaTuttiP(){
        try(Connection con = ConPool.getConnection()){
            ArrayList<Pagamento> list = new ArrayList<Pagamento>();
            PreparedStatement ps = con.prepareStatement("SELECT nTransazione FROM pagamento");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(AmministratoreDAO.ricercaIdP(rs.getInt(1)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Documento
     * @return una lista di oggetti Documento
     */
    public List<Documento> ricercaTuttiDo(){
        try(Connection con = ConPool.getConnection()){
            ArrayList<Documento> list = new ArrayList<Documento>();
            PreparedStatement ps = con.prepareStatement("SELECT nDocumento FROM documento");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(AmministratoreDAO.ricercaIdD(rs.getString(1)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Prodottodocumento
     * @return una lista di oggetti Prodottodocumento
     */
    public List<ProdottoDocumento> ricercaTuttiPd(){
        try(Connection con = ConPool.getConnection()){
            ArrayList<ProdottoDocumento> list = new ArrayList<ProdottoDocumento>();
            PreparedStatement ps = con.prepareStatement("SELECT codiceArt,codiceDoc FROM pagamento");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(AmministratoreDAO.ricercaIdPd(rs.getString(1),rs.getString(2)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Metodo per ricercare tutti gli elementi della tabella Clientefornitore
     * @return una lista di oggetti Clientefornitore
     */
    public List<ClienteFornitore> ricercaTuttiCf(){
        try(Connection con = ConPool.getConnection()){
            ArrayList<ClienteFornitore> list = new ArrayList<ClienteFornitore>();
            PreparedStatement ps = con.prepareStatement("SELECT cf FROM clientefornitore");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                list.add(AmministratoreDAO.ricercaIdCf(rs.getString(1)));
            }
            return list;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<ClienteFornitore> ricercaTuttiCfS(boolean scelta) {
        List<ClienteFornitore> lista = ricercaTuttiCf();

        List<ClienteFornitore> toReturn = new ArrayList<ClienteFornitore>();

        int size = scelta?16:11;

        for(ClienteFornitore c:lista){
            if(c.getCf().length()==size)
                toReturn.add(c);
        }

        return  toReturn;
    }
}
