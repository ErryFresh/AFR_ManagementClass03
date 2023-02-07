package ENTITY;
//CREDENZIALI DIPENDENTE PROVA: email- a@b.it psw- prova
public class Dipendente {
    private String matricola;
    private String password;
    private String cf;
    private String nome;
    private String cognome;
    private String recapito;
    private String email;
    private String posizione;
    private int codiceRep;

    public Dipendente(){};

    public Dipendente(String cf, String nome, String cognome, String recapito, String email, String posizione, int codiceRep) {
        this.cf = cf;
        this.nome = nome;
        this.cognome = cognome;
        this.recapito = recapito;
        this.email = email;
        this.posizione = posizione;
        this.codiceRep = codiceRep;
    }

    public Dipendente(String matricola, String password, String cf, String nome, String cognome, String recapito, String email, String posizione, int codiceRep) {
        this.matricola = matricola;
        this.password = password;
        this.cf = cf;
        this.nome = nome;
        this.cognome = cognome;
        this.recapito = recapito;
        this.email = email;
        this.posizione = posizione;
        this.codiceRep = codiceRep;
    }

    @Override
    public String toString() {
        return "Dipendente{" +
                "matricola='" + matricola + '\'' +
                ", password='" + password + '\'' +
                ", cf='" + cf + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", recapito='" + recapito + '\'' +
                ", email='" + email + '\'' +
                ", posizione='" + posizione + '\'' +
                ", codiceRep='" + codiceRep + '\'' +
                '}';
    }

    public String getMatricola() {
        return matricola;
    }

    public void setMatricola(String matricola) {
        this.matricola = matricola;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCf() {
        return cf;
    }

    public void setCf(String cf) {
        this.cf = cf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public String getRecapito() {
        return recapito;
    }

    public void setRecapito(String recapito) {
        this.recapito = recapito;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosizione() {
        return posizione;
    }

    public void setPosizione(String posizione) {
        this.posizione = posizione;
    }

    public int getCodiceRep() {
        return codiceRep;
    }

    public void setCodiceRep(int codiceRep) {
        this.codiceRep = codiceRep;
    }
}
