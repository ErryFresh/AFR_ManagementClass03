package LogicTier;

import DataTier.MagazzinoDAO;
import Entity.Prodottoscaffale;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;
@Stateless
@LocalBean
public class GestioneProdottoScaffale {

    public static MagazzinoDAO m = MagazzinoDAO.getInstance();

    public void addProdottoScaffale(Prodottoscaffale ps){m.addProdottoScaffale(ps);}

    public void removeProdottoScaffale(Prodottoscaffale ps){m.removeProdottoScaffale(ps);}

    public Prodottoscaffale updateProdottoScaffale(Prodottoscaffale ps){return m.updateProdottoScaffale(ps);}

    public Prodottoscaffale ricercaIdPs(String idP,int idS){return m.ricercaIdPs(idP,idS);}

    public List<Prodottoscaffale> ricercaTuttiPs(){return m.ricercaTuttiPs();}

}
