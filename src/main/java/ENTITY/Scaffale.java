package ENTITY;

public class Scaffale {
    private int codiceScaffale;
    private String nome;
    private String descrizione;
    private int codiceMagazzino;
    private double surOccupata;
    private double surDisponibile;
public Scaffale(){}
    public Scaffale(int codiceScaffale, String nome, String descrizione, int codiceMagazzino, double surOccupata, double surDisponibile) {
        this.codiceScaffale = codiceScaffale;
        this.nome = nome;
        this.descrizione = descrizione;
        this.codiceMagazzino = codiceMagazzino;
        this.surOccupata = surOccupata;
        this.surDisponibile = surDisponibile;
    }

    public int getCodiceScaffale() {
        return codiceScaffale;
    }

    public void setCodiceScaffale(int codiceScaffale) {
        this.codiceScaffale = codiceScaffale;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public int getCodiceMagazzino() {
        return codiceMagazzino;
    }

    public void setCodiceMagazzino(int codiceMagazzino) {
        this.codiceMagazzino = codiceMagazzino;
    }

    public double getSurOccupata() {
        return surOccupata;
    }

    public void setSurOccupata(double surOccupata) {
        this.surOccupata = surOccupata;
    }

    public double getSurDisponibile() {
        return surDisponibile;
    }

    public void setSurDisponibile(double surDisponibile) {
        this.surDisponibile = surTotale;
    }

    @Override
    public String toString() {
        return "Scaffale{" +
                "codiceScaffale='" + codiceScaffale + '\'' +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", codiceMagazzino='" + codiceMagazzino + '\'' +
                ", surOccupata=" + surOccupata +
                ", surTotale=" + surDisponibile +
                '}';
    }
}
