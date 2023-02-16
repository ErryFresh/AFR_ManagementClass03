package LogicTier.addCliente;
import ENTITY.ClienteFornitore;
import LogicTier.GestioneClientiFornitori;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GestioneClientiFornitoriTest {

    GestioneClientiFornitori g = new GestioneClientiFornitori();

    private validateClienteFornitore  v = new validateClienteFornitore();

    @Test
    public void TC_4_1() {
        String cf = "RSSMRA80A01";
        assertEquals("false",v.validateCF(cf), "Il dipendente riesce ad aggiungere il Cliente/Fornitore");
    }
    @Test
    public void TC_4_3(){
        String nome = "Ma$$o";
        assertEquals("false",v.validateNome(nome));
    }
    @Test
    public void TC_4_4(){
        String nome = "MassimoGasparreMicroMachineRespundo";
        assertEquals("false",v.validateNome(nome));
    }
    @Test
    public void TC_4_5(){
        String cognome = "&£posto";
        assertEquals("false",v.validateCognome(cognome));

    }
    @Test
    public void TC_4_6(){
        String cognome = "mastroberardinomastrofrancescounteregelsbacherluther";
        assertEquals("false",v.validateCognome(cognome));
    }
    @Test
    public void TC_4_7(){
        String recapito = "156";
        assertEquals("false",v.validateRecapito(recapito));
    }
    @Test
    public void TC_4_8(){
        String recapito = "3385637368";
        assertEquals("false",v.validateRecapito(recapito));
    }

    @Test
    public void TC_4_10(){
        String eMail = ".it";
        assertEquals("false",v.validateEmail(eMail));
    }
    @Test
    public void TC_4_11(){
        String eMail = "jhino@.it";
        assertEquals("false",v.validateEmail(eMail));
    }
    @Test
    public void TC_4_12(){
        String eMail = "jhin@@industries.it";
        assertEquals("false",v.validateEmail(eMail));
    }
    @Test
    public void TC_4_13(){
        String eMail = ".jhiorr@industries.it";
        assertEquals("false",v.validateEmail(eMail));
    }
    @Test
    public void TC_4_14(){
        String eMail = "jhiorr@.industries.it";
        assertEquals("false",v.validateEmail(eMail));
    }
    @Test
    public void TC_4_15(){
        String eMail = "mario..rossi@@industries.it";
        assertEquals("false",v.validateEmail(eMail));
    }
    @Test
    public void TC_4_16(){
        String eMail = "mario^.rossi12@industries.it";
        assertEquals("false",v.validateEmail(eMail));
    }
    @Test
    public void TC_4_17(){
        String eMail = "mario.rossi12@&^%.it";
        assertEquals("false",v.validateEmail(eMail));
    }

    @Test
    public void TC_4_2(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
            g.addClienteFornitore(new ClienteFornitore(v.validateCF("RSSMRA80A17G762A"),v.validateNome("Mario"),v.validateCognome("Rossi"),v.validateRecapito("+393385637368"),v.validateEmail("mario.rossi12@industries.it")));
        });

        String expectedMessage = "false";
        String actualMessage = exception.getMessage();

        assertFalse(actualMessage.contains(expectedMessage));

    }

    @Test
    public void TC_4_9(){
        Exception exception = assertThrows(RuntimeException.class, () -> {
        g.addClienteFornitore(new ClienteFornitore(v.validateCF("RSSMRA80A17G762F"),v.validateNome("Mario"),v.validateCognome("Rossi"),v.validateRecapito("+393385637368"),v.validateEmail("mario.rossi12@industries.it")));
        });

        String expectedMessage = "false";
        String actualMessage = exception.getMessage();

        assertFalse(actualMessage.contains(expectedMessage));
    }

}