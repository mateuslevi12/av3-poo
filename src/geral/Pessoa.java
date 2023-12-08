package geral;

public class Pessoa {
    private String nome;
    private String idade;
    private String email;
    private int numeroDeTelefone;

    public Pessoa(String nome, String idade, String email, int numeroDeTelefone) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.numeroDeTelefone = numeroDeTelefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    public void setNumeroDeTelefone(int numeroDeTelefone) {
        this.numeroDeTelefone = numeroDeTelefone;
    }

    @Override
    public String toString() {
        return "  Seu nome=" + nome + ", sua idade=" + idade + ", seu email=" + email + ", seu numeroDeTelefone="
                + numeroDeTelefone;
    };

    
    
}
