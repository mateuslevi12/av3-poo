package geral;

import classesAbstratas.Pessoa;

public class Gerente extends Pessoa {
    private int senha;

    public Gerente(String nome, int idade, String email, int numeroDeTelefone, int senha) {
        super(nome, idade, email, numeroDeTelefone);
        this.senha = senha;
    }

    public int getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Gerente " + getNome() + "senha=" + senha;
    }

}
