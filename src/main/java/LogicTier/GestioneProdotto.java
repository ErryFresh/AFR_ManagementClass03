package LogicTier;

import DataTier.MagazzinoDAO;
import ENTITY.Prodotto;
import java.util.List;

public class GestioneProdotto {

    public static MagazzinoDAO m = MagazzinoDAO.getInstance();

    public void addProdotto(Prodotto p){m.addProdotto(p);}

    public void removeProdotto(String p){m.removeProdotto(p);}

    public void updateProdotto(Prodotto p){m.updateProdotto(p);}

    public Prodotto ricercaIdP(String id){return m.ricercaIdP(id);}

    public List<Prodotto> ricercaTuttiP(){return m.ricercaTuttiP();}

}
