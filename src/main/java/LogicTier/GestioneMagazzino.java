package LogicTier;

import DataTier.MagazzinoDAO;
import ENTITY.Magazzino;
import java.util.List;

public class GestioneMagazzino {

    public static MagazzinoDAO m = MagazzinoDAO.getInstance();

    public void addMagazzino(Magazzino mag){m.addMagazzino(mag);}

    public void removeMagazzino(String mag){m.removeMagazzino(mag);}

    public Magazzino updateMagazzino(Magazzino mag){return m.updateMagazzino(mag);}

    public Magazzino ricercaIdC(int id){return m.ricercaIdM(id);}

    public List<Magazzino> ricercaTuttiM(){return m.ricercaTuttiM();}

}
