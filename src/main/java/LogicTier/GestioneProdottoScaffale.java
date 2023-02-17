package LogicTier;
import DataTier.MagazzinoDAO;
import ENTITY.ProdottoScaffale;
import java.util.List;
/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sara' mai l'utente a interfacciarsi direttamente con i dati persistenti
 * del ProdottoScaffale evitando errori che possano comprometterne la qualita' e garantendo la sicurezza dei dati.
 * L'interfaccia contiene azioni CRUD e due tipi di ricerca per ID e generale.
 */
public class GestioneProdottoScaffale {

    public static MagazzinoDAO m = MagazzinoDAO.getSingle_instance();

    public void addProdottoScaffale(ProdottoScaffale ps){m.addProdottoScaffale(ps);}

    public void removeProdottoScaffale(String codiceArt,int codiceSc){m.removeProdottoScaffale(codiceArt,codiceSc);}

    public void updateProdottoScaffale(ProdottoScaffale ps){m.updateProdottoScaffale(ps);}

    public ProdottoScaffale ricercaIdPs(String idP,int idS){return m.ricercaIdPs(idP,idS);}

    public List<ProdottoScaffale> ricercaTuttiPs(){return m.ricercaTuttiPs();}

}
