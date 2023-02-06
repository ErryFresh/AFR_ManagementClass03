package ENTITY;

public class Calendario {
    private String codiceCal;
    private String nome;
    private String codiceRep;
    private String matricola;

    public Calendario(String codiceCal, String nome, String codiceRep, String matricola) {
        this.codiceCal = codiceCal;
        this.nome = nome;
        this.codiceRep = codiceRep;
        this.matricola = matricola;
    }

    public String getCodiceCal() {
        return codiceCal;
    }

    public void setCodiceCal(String codiceCal) {
        this.codiceCal = codiceCal;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodiceRep() {
        return codiceRep;
    }

    public void setCodiceRep(String codiceRep) {
        this.codiceRep = codiceRep;
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    @Override
    public String toString() {
        return "Calendario{" +
                "codiceCal='" + codiceCal + '\'' +
                ", nome='" + nome + '\'' +
                ", codiceRep='" + codiceRep + '\'' +
                ", matricola='" + matricola + '\'' +
                '}';
    }
}
