package geral;

import java.util.List;

import excecao.EstoqueException;

public class Cliente extends Pessoa{
     private List<Produto> itensCarrinho;
    private double saldo;

    public Cliente(String nome, String idade, String email, int numeroDeTelefone, List<Produto> itensCarrinho,
            double saldo) {
        super(nome, idade, email, numeroDeTelefone);
        this.itensCarrinho = itensCarrinho;
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente: " + getNome() + "saldo= " + saldo;
    }

    @Override
    public void adicionarItem(Produto produto) {
        itensCarrinho.add(produto);
        System.out.println("Produto adicionado ao carrinho: " + produto.getNome());
    }

    @Override
    public void removerItem(Produto produto) {
        itensCarrinho.remove(produto);
        System.out.println("Produto removido do carrinho: " + produto.getNome());
    }

    public void mostrarCarrinho() {
        if (itensCarrinho.isEmpty()) {
            throw new EstoqueException("Carrinho está vazio");
        }
        System.out.println(itensCarrinho);
    }

    
    
}
