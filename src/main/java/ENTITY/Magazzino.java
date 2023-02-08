package ENTITY;

public class Magazzino {
    private int codiceMagazzino;
    private String indirizzo;
    private int nScaffali;
    public Magazzino(){}
    public Magazzino(int codiceMagazzino, String indirizzo, int nScaffali) {
        this.codiceMagazzino = codiceMagazzino;
        this.indirizzo = indirizzo;
        this.nScaffali = nScaffali;
    }

    public int getCodiceMagazzino() {
        return codiceMagazzino;
    }

    public void setCodiceMagazzino(int codiceMagazzino) {
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
