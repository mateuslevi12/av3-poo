package classesAbstratas;


public abstract class Pessoa {
    protected String nome;
    protected int idade;
    protected String email;
    protected int numeroDeTelefone;

    public Pessoa(String nome, int idade, String email, int numeroDeTelefone) {
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

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
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
    }

}
