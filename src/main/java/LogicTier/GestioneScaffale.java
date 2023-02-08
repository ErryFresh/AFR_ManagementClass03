package LogicTier;

import DataTier.MagazzinoDAO;
import ENTITY.Scaffale;
import java.util.List;

public class GestioneScaffale {

    public static MagazzinoDAO m = MagazzinoDAO.getInstance();

    public void addScaffale(Scaffale s){m.addScaffale(s);}

    public void removeScaffale(int s){m.removeScaffale(s);}

    public void updateScaffale(Scaffale s){m.updateScaffale(s);}

    public Scaffale ricercaIdS(int id){return m.ricercaIdS(id);}

    public List<Scaffale> ricercaTuttiS(){return m.ricercaTuttiS();}

}
