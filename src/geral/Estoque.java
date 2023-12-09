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

    // public void estoqueInicial() {
    //     itensEstoque.add(new Celular(null, 0, null, null, null, null, 0, 0));
    // }

    public void mostrarEstoque() {
        // estoqueInicial();
        if (itensEstoque.isEmpty()) {
            throw new EstoqueException("Estoque esta vazio");
        }
        for (Produto produto : itensEstoque) {
            System.out.println(produto); // Isso imprimirá cada produto em uma linha separada
        }
    }
}

