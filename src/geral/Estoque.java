package geral;

import java.util.ArrayList;
import java.util.List;
import classesAbstratas.Produto;
import excecao.EstoqueException;
import excecao.ProdutoIndisponivelException;
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
    public void removerItem(int index) {
        try {
            if (index >= 0 && index < itensEstoque.size()) {
                Produto produtoRemovido = itensEstoque.remove(index);
                System.out.println("Produto removido do estoque: " + produtoRemovido.getNome());
            } else {
                throw new ProdutoIndisponivelException("Produto não encontrado");
            }
        } catch (EstoqueException e) {
            if (itensEstoque.isEmpty()) {
                System.out.print("Estoque já está " + e.getMessage());
            }
        }
    }
    public void mostrarEstoque() throws EstoqueException {
        try {
            if (!itensEstoque.isEmpty()) {
                System.out.println("ESTOQUE");
                for (Produto produto : itensEstoque) {
                    System.out.println(produto);
                }
            } 
        } catch (EstoqueException e) {
            System.out.println("Estoque " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Estoque [itensEstoque=" + itensEstoque + "]";
    }

    
}

