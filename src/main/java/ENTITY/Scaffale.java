package ENTITY;

public class Scaffale {
    private String codiceScaffale;
    private String nome;
    private String descrizione;
    private String codiceMagazzino;
    private double surOccupata;
    private double surTotale;

    public Scaffale(String codiceScaffale, String nome, String descrizione, String codiceMagazzino, double surOccupata, double surTotale) {
        this.codiceScaffale = codiceScaffale;
        this.nome = nome;
        this.descrizione = descrizione;
        this.codiceMagazzino = codiceMagazzino;
        this.surOccupata = surOccupata;
        this.surTotale = surTotale;
    }

    public String getCodiceScaffale() {
        return codiceScaffale;
    }

    public void setCodiceScaffale(String codiceScaffale) {
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

    public String getCodiceMagazzino() {
        return codiceMagazzino;
    }

    public void setCodiceMagazzino(String codiceMagazzino) {
        this.codiceMagazzino = codiceMagazzino;
    }

    public double getSurOccupata() {
        return surOccupata;
    }

    public void setSurOccupata(double surOccupata) {
        this.surOccupata = surOccupata;
    }

    public double getSurTotale() {
        return surTotale;
    }

    public void setSurTotale(double surTotale) {
        this.surTotale = surTotale;
    }

    @Override
    public String toString() {
        return "Scaffale{" +
                "codiceScaffale='" + codiceScaffale + '\'' +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", codiceMagazzino='" + codiceMagazzino + '\'' +
                ", surOccupata=" + surOccupata +
                ", surTotale=" + surTotale +
                '}';
    }
}
