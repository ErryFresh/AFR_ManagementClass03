package ENTITY;

public class ProdottoScaffale {

    private int prodottoScaf;
    private String codiceArt;
    private int codiceScaffale;
    private int qta;
    private double lunghezza;
    private double larghezza;
    private double altezza;
    public ProdottoScaffale(){}
    public ProdottoScaffale(String codiceArt, int codiceScaffale, int qta, double lunghezza, double larghezza, double altezza) {
        this.codiceArt = codiceArt;
        this.codiceScaffale = codiceScaffale;
        this.qta = qta;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public ProdottoScaffale(int prodottoScaf, String codiceArt, int codiceScaffale, int qta, double lunghezza, double larghezza, double altezza) {
        this.prodottoScaf = prodottoScaf;
        this.codiceArt = codiceArt;
        this.codiceScaffale = codiceScaffale;
        this.qta = qta;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public int getProdottoScaf() {
        return prodottoScaf;
    }

    public void setProdottoScaf(int prodottoScaf) {
        this.prodottoScaf = prodottoScaf;
    }

    public String getCodiceArt() {
        return codiceArt;
    }

    public void setCodiceArt(String codiceArt) {
        this.codiceArt = codiceArt;
    }

    public int getCodiceScaffale() {
        return codiceScaffale;
    }

    public void setCodiceScaffale(int codiceScaffale) {
        this.codiceScaffale = codiceScaffale;
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
        return "ProdottoScaffale{" +
                "prodottoScaf=" + prodottoScaf +
                ", codiceArt='" + codiceArt + '\'' +
                ", codiceScaffale=" + codiceScaffale +
                ", qta=" + qta +
                ", lunghezza=" + lunghezza +
                ", larghezza=" + larghezza +
                ", altezza=" + altezza +
                '}';
    }
}
