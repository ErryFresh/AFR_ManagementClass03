package LogicTier.addDocumento;

import ENTITY.ClienteFornitore;
import ENTITY.Documento;
import LogicTier.GestioneDocumenti;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



public class GestioneDocumentoTest {

    GestioneDocumenti gd = new GestioneDocumenti();

    private validateDocumento v = new validateDocumento();

    @Test
    public void TC_3_1(){
        String nome = "Fàttur4";
        assertEquals("false",v.typeChecker(nome),"Il dipendente ha aggiunto con successo il documento");
    }

    @Test
    public void TC_3_2(){
        String tipo = "Lorem ipsum dolor sit amet consectetur adipisicing elit";
        assertEquals("false",v.lenghtChecker(tipo));
    }

    @Test
    public void TC_3_3(){
        String data = "2032-01-10";
        assertEquals("false",v.dateChecker(data));
    }

    @Test
    public void TC_3_4(){
        String note = "Fattura! relativa all?acquisto dell’ordine numero DF100.";
        assertEquals("false",v.noteChecker(note));
    }

    @Test
    public void TC_3_5(){
        String note = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Maxime mollitia,\n" +
                "molestiae quas vel sint commodi repudiandae consequuntur voluptatum laborum\n" +
                "numquam blanditiis harum quisquam eius sed odit fugiat iusto fuga praesentium\n" +
                "optio, eaque rerum!";
        assertEquals("false",v.noteChecker(note));
    }
}
