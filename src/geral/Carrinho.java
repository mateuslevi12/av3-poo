package geral;

import java.util.ArrayList;
import java.util.List;

import excecao.EstoqueException;
import interfaces.GerenciamentoItens;

public class Carrinho implements GerenciamentoItens {
    private List<Produto> itensCarrinho;
    private int quantidadeCarrinho;
    private double valorCarrinho;
    
    public Carrinho() {
        this.itensCarrinho = new ArrayList<>();
    }
    
    
    public List<Produto> getItensCarrinho() {
        return itensCarrinho;
    }

    @Override
    public void adicionarItem(Produto produto) {
        quantidadeCarrinho++;
        valorCarrinho += produto.getPreco();
        itensCarrinho.add(produto);
        System.out.println(produto.getNome() + " adicionado com sucesso!!" );
    }

    @Override
    public void removerItem(Produto produto) {
        quantidadeCarrinho--;
        itensCarrinho.remove(produto);
        System.out.println("Produto removido do carrinho: " + produto.getNome());
    }
    
    public void mostrarCarrinho() {
        if (quantidadeCarrinho <= 0 ) {
            throw new EstoqueException("Carrinho esta vazio");
        }
        System.out.println("CARRINHO");
        for (Produto produto : itensCarrinho) {
            System.out.println(produto); // Isso imprimirá cada produto em uma linha separada
        }
        
        System.out.println("valor total: " + valorCarrinho );
    }
    
    public double getValorCarrinho() {
        return valorCarrinho;
    }

}

