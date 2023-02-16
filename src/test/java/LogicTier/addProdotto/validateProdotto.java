package LogicTier.addProdotto;

import java.util.regex.Pattern;

public class validateProdotto {

    public validateProdotto(){}
    public boolean validateNome(String nome){
        return nome.matches("[a-zA-Z0-9]+");
    }

    public boolean validateLunghezzaNome(String nome){
        if(nome.length()<30)
            return true;
        return false;
    }
    public boolean validateDescrizione(String descrizione){
        return descrizione.matches("[a-zA-Z0-9' '+,.°*-]+");
    }

    public boolean validatePrezzoAcquisto(String prezzoAcquisto){
        return prezzoAcquisto.matches("[0-9.]+");
    }

    public boolean validatePrezzoVendita(String prezzoVendita){
        return prezzoVendita.matches("[0-9.]+");
    }

    public boolean validateTipologiaVendita(String tipologiaVendita){
        return tipologiaVendita.matches("[a-zA-Z]+");
    }

    public boolean validateLunghezzaTipologiaVendita(String tipologiaVendita){
        if(tipologiaVendita.length()<10)
            return true;
        return false;
    }
}
