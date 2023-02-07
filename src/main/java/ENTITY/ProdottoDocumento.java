package ENTITY;

public class ProdottoDocumento {
    private String codiceArt;
    private String codiceDoc;
    private int qta;
    private double lunghezza;
    private double larghezza;
    private double altezza;

    public ProdottoDocumento(){}
    public ProdottoDocumento(String codiceArt, String codiceDoc, int qta, double lunghezza, double larghezza, double altezza) {
        this.codiceArt = codiceArt;
        this.codiceDoc = codiceDoc;
        this.qta = qta;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public String getCodiceArt() {
        return codiceArt;
    }

    public void setCodiceArt(String codiceArt) {
        this.codiceArt = codiceArt;
    }

    public String getCodiceDoc() {
        return codiceDoc;
    }

    public void setCodiceDoc(String codiceDoc) {
        this.codiceDoc = codiceDoc;
    }

    public int getQta() {
        return qta;
    }

    public void setQta(int qta) {
        this.qta = qta;
    }

    public double getLunghezza() {
        return lunghezza;
    }

    public void setLunghezza(double lunghezza) {
        this.lunghezza = lunghezza;
    }

    public double getLarghezza() {
        return larghezza;
    }

    public void setLarghezza(double larghezza) {
        this.larghezza = larghezza;
    }

    public double getAltezza() {
        return altezza;
    }

    public void setAltezza(double altezza) {
        this.altezza = altezza;
    }

    @Override
    public String toString() {
        return "ProdottoDocumento{" +
                "codiceArt='" + codiceArt + '\'' +
                ", codiceDoc='" + codiceDoc + '\'' +
                ", qta=" + qta +
                ", lunghezza=" + lunghezza +
                ", larghezza=" + larghezza +
                ", altezza=" + altezza +
                '}';
    }
}
