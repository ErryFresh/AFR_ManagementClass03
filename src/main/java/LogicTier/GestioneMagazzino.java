package LogicTier;

import DataTier.MagazzinoDAO;
import ENTITY.Magazzino;
import ENTITY.Scaffale;

import java.util.List;

public class GestioneMagazzino {

    public GestioneMagazzino(){}

    public static MagazzinoDAO m = MagazzinoDAO.getInstance();

    public void addMagazzino(Magazzino mag){m.addMagazzino(mag);}

    public void removeMagazzino(int mag){m.removeMagazzino(mag);}

    public void updateMagazzino(Magazzino mag){m.updateMagazzino(mag);}

    public Magazzino ricercaIdC(int id){return m.ricercaIdM(id);}

    public List<Magazzino> ricercaTuttiM(){return m.ricercaTuttiM();}

    public List<Scaffale> ricercaTuttiS(){return m.ricercaTuttiS();}
}
