package LogicTier;

import DataTier.MagazzinoDAO;
import ENTITY.ProdottoScaffale;
import java.util.List;
public class GestioneProdottoScaffale {

    public static MagazzinoDAO m = MagazzinoDAO.getInstance();

    public void addProdottoScaffale(ProdottoScaffale ps){m.addProdottoScaffale(ps);}

    public void removeProdottoScaffale(String codiceArt,String codiceSc){m.removeProdottoScaffale(codiceArt,codiceSc);}

    public void updateProdottoScaffale(ProdottoScaffale ps){m.updateProdottoScaffale(ps);}

    public ProdottoScaffale ricercaIdPs(String idP,int idS){return m.ricercaIdPs(idP,idS);}

    public List<ProdottoScaffale> ricercaTuttiPs(){return m.ricercaTuttiPs();}

}
