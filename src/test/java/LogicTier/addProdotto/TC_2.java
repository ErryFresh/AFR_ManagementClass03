package LogicTier.addProdotto;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class TC_2 {

    private validateProdotto valProd = new validateProdotto();
    @Test
    public void TC_2_1(){
        String nome = "Porta_Penne";
        Assertions.assertEquals(false,valProd.validateNome(nome));
    }
    @Test
    public void TC_2_2(){
        String nome = "Cellulareyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy";
        Assertions.assertEquals(false,valProd.validateLunghezzaNome(nome));
    }

    @Test
    public void TC_2_3(){
        String descrizione = "Articolo (i)nformatico";
        Assertions.assertEquals(false,valProd.validateDescrizione(descrizione));
    }
    @Test
    public void TC_2_4(){
        String prezzoAcquisto = "-4";
        Assertions.assertEquals(false,valProd.validatePrezzoAcquisto(prezzoAcquisto));
    }

    @Test
    public void TC_2_5(){
        String prezzoVendita = ";600";
        Assertions.assertEquals(false,valProd.validatePrezzoVendita(prezzoVendita));
    }

    @Test
    public void TC_2_6(){
        String tipologiaVendita = "pz78";
        Assertions.assertEquals(false,valProd.validateTipologiaVendita(tipologiaVendita));
    }

    @Test
    public void TC_2_7(){
        String tipologiaVendita = "mirghioeruguoergoierhgiorhgiorehgierhgoierghoierghior";
        Assertions.assertEquals(false,valProd.validateLunghezzaTipologiaVendita(tipologiaVendita));
    }

    @Test
    public void TC_2_8(){
        String nome = "Cellulare";
        String descrizione = "Articolo informatico";
        String prezzoAcquisto = "120";
        String prezzoVendita = "160";
        String tipologiaVendita = "prova";
        Assertions.assertEquals(true,valProd.validateNome(nome));
        Assertions.assertEquals(true,valProd.validateLunghezzaNome(nome));
        Assertions.assertEquals(true,valProd.validateDescrizione(descrizione));
        Assertions.assertEquals(true,valProd.validatePrezzoAcquisto(prezzoAcquisto));
        Assertions.assertEquals(true,valProd.validatePrezzoVendita(prezzoVendita));
        Assertions.assertEquals(true,valProd.validateTipologiaVendita(tipologiaVendita));
        Assertions.assertEquals(true,valProd.validateLunghezzaTipologiaVendita(tipologiaVendita));
    }

}
