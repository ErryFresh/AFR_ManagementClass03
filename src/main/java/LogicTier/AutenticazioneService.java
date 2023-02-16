package LogicTier;

import DataTier.AutenticazioneDAO;
import DataTier.DipendenteDAO;
import ENTITY.Dipendente;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

/**
 * Classe che ci permette d'interfacciare l'utente col sistema, senza dare un accesso diretto sui dati
 * delle risorse. In questo modo non sará mai l'utente a interfacciarsi direttamente con i dati persistenti
 * dell'Autenticazione evitando errori che possano comprometterne la qualitá e garantendo la sicurezza dei dati.
 */
public class AutenticazioneService {
    private AutenticazioneDAO ad = AutenticazioneDAO.getSingle_instance();

    /**
     * il metodo ci permette di generare una password per il dipendente
     * @param len lunghezza della password
     * @return password generata automaticamente
     */
    private static String passwordGenerator(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

    /**
     * il metodo permette di cifrare la password
     * @param input password del dipendente da cifrare
     * @return password cifrata tramita SHA-1
     */
    private static String cifraPassword(String input)
    {
        try {

            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] messageDigest = md.digest(input.getBytes());
            BigInteger no = new BigInteger(1, messageDigest);

            String hashtext = no.toString(16);

            while (hashtext.length() < 32) {
                hashtext = "0" + hashtext;
            }

            return hashtext;
        }

        catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * il metodo permette di controllare se può essere effettuato il login sulle credenziali che vengono passate
     * @param psw password del dipendente
     * @param eMail email del dipendente
     * @return dipendente loggato correttamente
     */
    public Dipendente logIn(String psw, String eMail){
        return AutenticazioneDAO.getSingle_instance().logIn(cifraPassword(psw),eMail);
    }

    public String addDipendente(Dipendente d){
        Random r = new Random();
        boolean flag=false;

        DipendenteDAO dd = DipendenteDAO.getInstance();

        String matricola;
        long mat;
        do {
            mat = r.nextInt() + 5000000000L;
            matricola = String.valueOf(mat<0?mat*-1:mat);

            if(dd.ricercaIdD(matricola)==null)
                flag=true;

        }while (!flag);

        String psw = passwordGenerator(8);

        d.setMatricola(matricola);
        d.setPassword(cifraPassword(psw));
        ad.addDipendente(d);

        return psw;
    }
}
