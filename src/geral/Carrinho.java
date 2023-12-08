package geral;

import java.util.ArrayList;
import java.util.List;

import excecao.EstoqueException;
import interfaces.GerenciamentoItens;

public class Carrinho implements GerenciamentoItens {
        private List<Produto> itensCarrinho;
        private int quantidadeCarrinho;
    public Carrinho() {
        this.itensCarrinho = new ArrayList<>();
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
        if (quantidadeCarrinho <= 0 ) {
            throw new EstoqueException("Carrinho esta vazio");
        }
        System.out.println(itensCarrinho);
    }
}

