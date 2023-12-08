package geral;

import java.util.List;

import excecao.EstoqueException;

public class Gerente extends Pessoa {
    private int senha;
     private List<Produto> itensEstoque;

    public Gerente(String nome, String idade, String email, int numeroDeTelefone, int senha) {
        super(nome, idade, email, numeroDeTelefone);
        this.senha = senha;
    }

        @Override
    public void adicionarItem(Produto produto) {
        itensEstoque.add(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }

    @Override
    public void removerItem(Produto produto) {
        itensEstoque.remove(produto);
        System.out.println("Produto removido do carrinho: " + produto.getNome());
    }

    public void mostrarEstoque() {
        if (itensEstoque.isEmpty()) {
            throw new EstoqueException("Estoque esta vazio");
        }
        System.out.println(itensEstoque);
    }

    public int getSenha() {
        return senha;
    }

    @Override
    public String toString() {
        return "Gerente "+ getNome() + "senha=" + senha;
    }

    
}
