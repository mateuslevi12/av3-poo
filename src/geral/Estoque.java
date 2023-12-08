package geral;

import java.util.ArrayList;
import java.util.List;

import excecao.EstoqueException;
import interfaces.GerenciamentoItens;

public class Estoque implements GerenciamentoItens {
        private List<Produto> itensEstoque;
        private int quantidadeEstoque;

    public Estoque(List<Produto> itensEstoque, int quantidadeEstoque) {
            this.itensEstoque =  new ArrayList<>();
            this.quantidadeEstoque = quantidadeEstoque;
        }

        
    @Override
    public void adicionarItem(Produto produto) {
        itensEstoque.add(produto);
        System.out.println("Produto adicionado ao Estoque: " + produto.getNome());
    }

    @Override
    public void removerItem(Produto produto) {
        itensEstoque.remove(produto);
        System.out.println("Produto removido do Estoque: " + produto.getNome());
    }


    public void mostrarEstoque() {
        if (quantidadeEstoque <= 0) {
            throw new EstoqueException("Estoque esta vazio");
        }
        System.out.println(itensEstoque);
    }
}

