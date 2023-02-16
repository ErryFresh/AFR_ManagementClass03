package ENTITY;

/**
 * Oggetto che ci permette di tener conto del legame tra l'oggetto Documento e l'oggetto Prodotti che vengono citati in quest'ultimo.
 * L'oggetto esiste in quanto é possibile aggiungere informazioni come qta,lunghezza,larghezza,altezza del prodotto all'interno del documento.
 */
public class ProdottoDocumento {
    private String codiceArt;
    private String codiceDoc;
    private int qta;
    private double lunghezza;
    private double larghezza;
    private double altezza;

    private int prodottoDoc;

    public ProdottoDocumento(){}
    public ProdottoDocumento(String codiceArt, String codiceDoc, int qta, double lunghezza, double larghezza, double altezza) {
        this.codiceArt = codiceArt;
        this.codiceDoc = codiceDoc;
        this.qta = qta;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.altezza = altezza;
    }

    public ProdottoDocumento(int prodottoDoc,String codiceArt, String codiceDoc, int qta, double lunghezza, double larghezza, double altezza) {
        this.codiceArt = codiceArt;
        this.codiceDoc = codiceDoc;
        this.qta = qta;
        this.lunghezza = lunghezza;
        this.larghezza = larghezza;
        this.altezza = altezza;
        this.prodottoDoc = prodottoDoc;
    }

    public int getProdottoDoc() {return prodottoDoc;}

    public void setProdottoDoc(int prodottoDoc) {this.prodottoDoc = prodottoDoc;}

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
                " prodottoDoc=" + prodottoDoc +
                ", codiceArt='" + codiceArt + '\'' +
                ", codiceDoc='" + codiceDoc + '\'' +
                ", qta=" + qta +
                ", lunghezza=" + lunghezza +
                ", larghezza=" + larghezza +
                ", altezza=" + altezza +
                '}';
    }
}
