package classesAbstratas;

// não é possivel instanciar uma pessoa
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

    public int getIdade() {
        return idade;
    }

    public String getEmail() {
        return email;
    }

    public int getNumeroDeTelefone() {
        return numeroDeTelefone;
    }

    @Override
    public String toString() {
        return "  Seu nome=" + nome + ", sua idade=" + idade + ", seu email=" + email + ", seu numeroDeTelefone="
                + numeroDeTelefone;
    }

}
