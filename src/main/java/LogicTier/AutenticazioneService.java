package LogicTier;

import DataTier.AutenticazioneDAO;
import DataTier.DipendenteDAO;
import ENTITY.Dipendente;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;
/**
 *Classe che permette di effettuare il login di un Dipendente e generazione automatica delle credenziali di quest'ultimo
 * Ciframento delle password.
 */

public class AutenticazioneService {

    private AutenticazioneDAO ad = AutenticazioneDAO.getSingle_instance();

    private static String passwordGenerator(int len) {
        String chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz!@#$%&";
        Random rnd = new Random();
        StringBuilder sb = new StringBuilder(len);
        for (int i = 0; i < len; i++)
            sb.append(chars.charAt(rnd.nextInt(chars.length())));
        return sb.toString();
    }

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
