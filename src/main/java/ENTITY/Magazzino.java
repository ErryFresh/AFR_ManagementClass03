package ENTITY;

public class Magazzino {
    private String codiceMagazzino;
    private String indirizzo;
    private int nScaffali;

    public Magazzino(String codiceMagazzino, String indirizzo, int nScaffali) {
        this.codiceMagazzino = codiceMagazzino;
        this.indirizzo = indirizzo;
        this.nScaffali = nScaffali;
    }

    public String getCodiceMagazzino() {
        return codiceMagazzino;
    }

    public void setCodiceMagazzino(String codiceMagazzino) {
        this.codiceMagazzino = codiceMagazzino;
    }

    public String getIndirizzo() {
        return indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    public int getnScaffali() {
        return nScaffali;
    }

    public void setnScaffali(int nScaffali) {
        this.nScaffali = nScaffali;
    }

    @Override
    public String toString() {
        return "Magazzino{" +
                "codiceMagazzino='" + codiceMagazzino + '\'' +
                ", indirizzo='" + indirizzo + '\'' +
                ", nScaffali=" + nScaffali +
                '}';
    }
}
