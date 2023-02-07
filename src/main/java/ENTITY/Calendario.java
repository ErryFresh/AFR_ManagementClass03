package ENTITY;

public class Calendario {
    private String codiceCal;
    private String nome;
    private int codiceRep;
    private String matricola;
    public Calendario(){};
    public Calendario(String codiceCal, String nome, int codiceRep, String matricola) {
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

    public int getCodiceRep() {
        return codiceRep;
    }

    public void setCodiceRep(int codiceRep) {
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
