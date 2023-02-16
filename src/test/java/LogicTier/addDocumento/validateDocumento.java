package LogicTier.addDocumento;

import java.util.Date;

public class validateDocumento {

    public String typeChecker(String tipo){
        if(tipo.equalsIgnoreCase("Fattura")||tipo.equalsIgnoreCase("Preventivo")||tipo.equalsIgnoreCase("ddt")||tipo.equalsIgnoreCase("documento di trasporto")) {
            return tipo;
        }
        return "false";
    }

    public String lenghtChecker(String tipo){
        if(tipo.length()<50) {
            return tipo;
        }
        return "false";
    }

    public String noteChecker(String note){
        char forbiddenCharacters[] = "!@#$%&".toCharArray();

        int MAX_LENGHT=250;

        if(note.length()>MAX_LENGHT)
            return "false";

        for(char c:forbiddenCharacters){
            String s = String.valueOf(c);
            if(note.contains(s))
                return "false";
        }
        return note;
    }
    /*
     * Nota: questo metodo presenta 3 istruzioni if separate al dine di fornire un controllo a grana più fine e soprattutto
     * più semplice in quanto non vi è necessità di utilizzare operatori quali && ed || per gestire varie possibili combinazioni.
     * In questa maniera vengono verificate in ordine: anno poi mese e poi giorno, appena uno dei 3 controlli fallisce, viene resituito tale esito
     */
    public String dateChecker(String date){
        Date data = new Date();

        int dd = data.getDate();
        int mm = data.getMonth()+1;
        int yy = data.getYear()+1900;

        String dates[] = date.split("-");

        if(Integer.parseInt(dates[0])>yy)
            return "false";
        if(Integer.parseInt(dates[1])>mm)
            return "false";
        if(Integer.parseInt(dates[2])>dd)
            return "false";

        return date;
    }
}
