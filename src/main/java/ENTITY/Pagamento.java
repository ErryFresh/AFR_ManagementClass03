package ENTITY;

import java.util.Date;

public class Pagamento {
    private int nTransazione;
    private String nAssegno;
    private String causale;
    private boolean saldato;
    private Date emissione;
    private Date scadenza;
    private String beneficiario;
    private String emittente;

    public Pagamento(String nAssegno, String causale, boolean saldato, Date emissione, Date scadenza, String beneficiario, String emittente) {
        this.nAssegno = nAssegno;
        this.causale = causale;
        this.saldato = saldato;
        this.emissione = emissione;
        this.scadenza = scadenza;
        this.beneficiario = beneficiario;
        this.emittente = emittente;
    }

    public Pagamento(int nTransazione, String nAssegno, String causale, boolean saldato, Date emissione, Date scadenza, String beneficiario, String emittente) {
        this.nTransazione = nTransazione;
        this.nAssegno = nAssegno;
        this.causale = causale;
        this.saldato = saldato;
        this.emissione = emissione;
        this.scadenza = scadenza;
        this.beneficiario = beneficiario;
        this.emittente = emittente;
    }

    public int getnTransazione() {
        return nTransazione;
    }

    public void setnTransazione(int nTransazione) {
        this.nTransazione = nTransazione;
    }

    public String getnAssegno() {
        return nAssegno;
    }

    public void setnAssegno(String nAssegno) {
        this.nAssegno = nAssegno;
    }

    public String getCausale() {
        return causale;
    }

    public void setCausale(String causale) {
        this.causale = causale;
    }

    public boolean isSaldato() {
        return saldato;
    }

    public void setSaldato(boolean saldato) {
        this.saldato = saldato;
    }

    public Date getEmissione() {
        return emissione;
    }

    public void setEmissione(Date emissione) {
        this.emissione = emissione;
    }

    public Date getScadenza() {
        return scadenza;
    }

    public void setScadenza(Date scadenza) {
        this.scadenza = scadenza;
    }

    public String getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(String beneficiario) {
        this.beneficiario = beneficiario;
    }

    public String getEmittente() {
        return emittente;
    }

    public void setEmittente(String emittente) {
        this.emittente = emittente;
    }

    @Override
    public String toString() {
        return "Pagamento{" +
                "nTransazione=" + nTransazione +
                ", nAssegno='" + nAssegno + '\'' +
                ", causale='" + causale + '\'' +
                ", saldato=" + saldato +
                ", emissione=" + emissione +
                ", scadenza=" + scadenza +
                ", beneficiario='" + beneficiario + '\'' +
                ", emittente='" + emittente + '\'' +
                '}';
    }
}