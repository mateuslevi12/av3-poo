package geral;

import java.util.ArrayList;
import java.util.List;

import excecao.EstoqueException;
import interfaces.GerenciamentoItens;

public class Estoque implements GerenciamentoItens {
    private List<Produto> itensEstoque =  new ArrayList<>();
        
    public Estoque() {}
    
    public List<Produto> getItensEstoque() {
        return itensEstoque;
    }

    public void setItensEstoque(List<Produto> itensEstoque) {
        this.itensEstoque = itensEstoque;
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
        System.out.println("ESTOQUE");
        for (Produto produto : itensEstoque) {
            System.out.println(produto); // Isso imprimirá cada produto em uma linha separada
        }
        if (itensEstoque.isEmpty()) {
            System.out.println("Estoque esta vazio");
        }
    }





}

