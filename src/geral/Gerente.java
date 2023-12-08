package geral;

public class Gerente extends Pessoa {
    private int senha;

    public Gerente(String nome, String idade, String email, int numeroDeTelefone, int senha) {
        super(nome, idade, email, numeroDeTelefone);
        this.senha = senha;
    }

    public int getSenha() {
        return senha;
    }

    public void setSenha(int senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Gerente "+ getNome() + "senha=" + senha;
    }

    
}
