package LogicTier;

import DataTier.MagazzinoDAO;
import Entity.Magazzino;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import java.util.List;

@Stateless
@LocalBean
public class GestioneMagazzino {

    public static MagazzinoDAO m = MagazzinoDAO.getInstance();

    public void addMagazzino(Magazzino mag){m.addMagazzino(mag);}

    public void removeMagazzino(Magazzino mag){m.removeMagazzino(mag);}

    public Magazzino updateMagazzino(Magazzino mag){return m.updateMagazzino(mag);}

    public Magazzino ricercaIdC(int id){return m.ricercaIdM(id);}

    public List<Magazzino> ricercaTuttiM(){return m.ricercaTuttiM();}

}
