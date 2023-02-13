package LogicTier;

import DataTier.MagazzinoDAO;
import ENTITY.Prodotto;
import java.util.List;
import java.util.Random;

public class GestioneProdotto {

    public static MagazzinoDAO m = MagazzinoDAO.getInstance();

    public void addProdotto(Prodotto p){m.addProdotto(p);}

    public void removeProdotto(String p){m.removeProdotto(p);}

    public void updateProdotto(Prodotto p){m.updateProdotto(p);}

    public Prodotto ricercaIdP(String id){return m.ricercaIdP(id);}

    public List<Prodotto> ricercaTuttiP(){return m.ricercaTuttiP();}

    public String generaChiaveProdotto(){
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(8);
        sb.append('P');
        sb.append('R');
        for (int i = 2; i < 8; i++)
            sb.append(rnd.nextInt(10));
        return sb.toString();
    }
}
