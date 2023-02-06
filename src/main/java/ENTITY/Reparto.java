package ENTITY;

public class Reparto {
    private int codiceReparto;
    private String nome;
    private String descrizione;

    public Reparto(String nome, String descrizione) {
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public Reparto(int codiceReparto, String nome, String descrizione) {
        this.codiceReparto = codiceReparto;
        this.nome = nome;
        this.descrizione = descrizione;
    }

    public int getCodiceReparto() {
        return codiceReparto;
    }

    public void setCodiceReparto(int codiceReparto) {
        this.codiceReparto = codiceReparto;
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

    @Override
    public String toString() {
        return "Reparto{" +
                "codiceReparto='" + codiceReparto + '\'' +
                ", nome='" + nome + '\'' +
                ", descrizione='" + descrizione + '\'' +
                '}';
    }
}
