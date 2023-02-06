package LogicTier;

import DataTier.MagazzinoDAO;
import Entity.Scaffale;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class GestioneScaffale {

    public static MagazzinoDAO m = MagazzinoDAO.getInstance();

    public void addScaffale(Scaffale s){m.addScaffale(s);}

    public void removeScaffale(Scaffale s){m.removeScaffale(s);}

    public Scaffale updateScaffale(Scaffale s){return m.updateScaffale(s);}

    public Scaffale ricercaIdS(int id){return m.ricercaIdS(id);}

    public List<Scaffale> ricercaTuttiS(){return m.ricercaTuttiS();}

}
