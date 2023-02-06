package ENTITY;

public class ClienteFornitore {
    private String cf;
    private String nome;
    private String cognome;
    private String recapito;
    private String email;

    public ClienteFornitore(String cf, String nome, String cognome, String recapito, String email) {
        this.cf = cf;
        this.nome = nome;
        this.cognome = cognome;
        this.recapito = recapito;
        this.email = email;
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

    @Override
    public String toString() {
        return "ClienteFornitore{" +
                "cf='" + cf + '\'' +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", recapito='" + recapito + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
