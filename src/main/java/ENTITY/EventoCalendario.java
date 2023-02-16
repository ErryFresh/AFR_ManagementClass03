package ENTITY;

import java.util.Date;

/**
 * Oggetto utile all'implementazione del Calendario, si tratta dell'evento che contiene. Composto da un codiceEvento (PK),nome,descrizione
 * data,matricola(dipendente),codiceCal(Calendario).
 */
public class EventoCalendario {
    private String codiceEvento;
    private String nome;
    private String descrizione;
    private String data;
    private String matricola;
    private String codiceCal;

    public EventoCalendario(){};
    public EventoCalendario(String codiceEvento, String nome, String descrizione, String data, String matricola, String codiceCal) {
        this.codiceEvento = codiceEvento;
        this.nome = nome;
        this.descrizione = descrizione;
        this.data = data;
        this.matricola = matricola;
        this.codiceCal = codiceCal;
    }

    public String getCodiceEvento() {
        return codiceEvento;
    }

    public void setCodiceEvento(String codiceEvento) {
        this.codiceEvento = codiceEvento;
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

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getCodiceCal() {
        return codiceCal;
    }

    public void setCodiceCal(String codiceCal) {
        this.codiceCal = codiceCal;
    }

    @Override
    public String toString() {
        return "EventoCalendario{" +
                "codiceEvento='" + codiceEvento + '\'' +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                ", data=" + data +
                ", matricola='" + matricola + '\'' +
                ", codiceCal='" + codiceCal + '\'' +
                '}';
    }
}
