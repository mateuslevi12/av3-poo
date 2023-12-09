package geral;

import java.util.ArrayList;
import java.util.List;

import excecao.EstoqueException;
import interfaces.GerenciamentoItens;

public class Estoque implements GerenciamentoItens {
        private List<Produto> itensEstoque =  new ArrayList<>();;
        

    public Estoque() {}

        
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
        if (itensEstoque.isEmpty()) {
            throw new EstoqueException("Estoque esta vazio");
        }
        System.out.println(itensEstoque);
    }
}

