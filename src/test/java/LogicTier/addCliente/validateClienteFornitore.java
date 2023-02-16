package LogicTier.addCliente;

import java.util.regex.Pattern;

public class validateClienteFornitore {
    public validateClienteFornitore(){}
    public String validateCF(String cf){
         if(cf.matches("^[A-Z]{6}[0-9]{2}[A-Z][0-9]{2}[A-Z][0-9]{3}[A-Z]$"))
             return cf;
         return "false";
    }

    public String validateNome(String nome){
        if(nome.matches("[a-zA-Z]{1,30}$"))
            return nome;
        return "false";
    }

    public String validateCognome(String cognome){

         if(cognome.matches("[a-zA-Z]{1,50}$"))
             return cognome;
         return "false";
    }

    public String validateRecapito(String recapito){
        if(recapito.matches("^\\+(?:[0-9]?){6,14}[0-9]$"))
            return recapito;
        return "false";
    }

    public String validateEmail(String eMail){
        if(eMail.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$"))
            return eMail;
        return "false";
    }

}
