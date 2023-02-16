package ENTITY;

/**
 * Oggetto prodotto descrive un prodotto che é possibile vendere, composto da codiceArt(PK),nome,descrizione,prezzoAcquisto,
 * prezzoVendita,tipologiaVendita(pezzo,metro-quadro etc.). Un oggetto prodotto viene inserito in un oggetto Scaffale.
 */
public class Prodotto {
    private String codiceArt;
    private String nome;
    private String descrizione;
    private double prezzoAcquisto;
    private double prezzoVendita;
    private String tipologiaVendita;
    public Prodotto(){}
    public Prodotto(String codiceArt, String nome, String descrizione, double prezzoAcquisto, double prezzoVendita, String tipologiaVendita) {
        this.codiceArt = codiceArt;
        this.nome = nome;
        this.descrizione = descrizione;
        this.prezzoAcquisto = prezzoAcquisto;
        this.prezzoVendita = prezzoVendita;
        this.tipologiaVendita = tipologiaVendita;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodiceArt() {
        return codiceArt;
    }

    public void setCodiceArt(String codiceArt) {
        this.codiceArt = codiceArt;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public double getPrezzoAcquisto() {
        return prezzoAcquisto;
    }

    public void setPrezzoAcquisto(double prezzoAcquisto) {
        this.prezzoAcquisto = prezzoAcquisto;
    }

    public double getPrezzoVendita() {
        return prezzoVendita;
    }

    public void setPrezzoVendita(double prezzoVendita) {
        this.prezzoVendita = prezzoVendita;
    }

    public String getTipologiaVendita() {
        return tipologiaVendita;
    }

    public void setTipologiaVendita(String tipologiaVendita) {
        this.tipologiaVendita = tipologiaVendita;
    }

    @Override
    public String toString() {
        return "Prodotto{" +
                "codiceArt='" + codiceArt + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", prezzoAcquisto=" + prezzoAcquisto +
                ", prezzoVendita=" + prezzoVendita +
                ", tipologiaVendita='" + tipologiaVendita + '\'' +
                '}';
    }
}
