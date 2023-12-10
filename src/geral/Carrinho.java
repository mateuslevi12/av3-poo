package geral;

import java.util.ArrayList;
import java.util.List;

import classesAbstratas.Produto;
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
        valorCarrinho -= produto.getPreco();
        itensCarrinho.remove(produto);
        System.out.println("Produto removido do carrinho: " + produto.getNome());
    }
    
    public void mostrarCarrinho() {
        try {
            System.out.println("----SEU CARRINHO----");
            for (Produto produto : itensCarrinho) {
                System.out.println(produto); // Isso imprimirá cada produto em uma linha separada
            }
            System.out.println("valor total: " + valorCarrinho );
        } catch (EstoqueException e) {
            if (itensCarrinho.isEmpty()) {
                System.out.print("Carrinho" + e.getMessage());
            }
        }
        
    }
    
    public double getValorCarrinho() {
        return valorCarrinho;
    }

}

