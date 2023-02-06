package LogicTier;

import DataTier.MagazzinoDAO;
import Entity.Prodotto;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class GestioneProdotto {

    public static MagazzinoDAO m = MagazzinoDAO.getInstance();

    public void addProdotto(Prodotto p){m.addProdotto(p);}

    public void removeProdotto(Prodotto p){m.removeProdotto(p);}

    public Prodotto updateProdotto(Prodotto p){return m.updateProdotto(p);}

    public Prodotto ricercaIdP(String id){return m.ricercaIdP(id);}

    public List<Prodotto> ricercaTuttiP(){return m.ricercaTuttiP();}

}
