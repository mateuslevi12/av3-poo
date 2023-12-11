package geral;

import java.util.ArrayList;
import java.util.List;

import classesAbstratas.Produto;
import excecao.EstoqueException;
import excecao.ProdutoIndisponivelException;
import interfaces.GerenciamentoItens;

public class Carrinho implements GerenciamentoItens {
    private List<Produto> itensCarrinho;
    private int quantidadeCarrinho;
    private double valorCarrinho;
    
    public Carrinho() {
        this.itensCarrinho = new ArrayList<>();
        this.valorCarrinho = 0;
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
    public void removerItem(int index) {
        try {
            if (index >= 0 && index < itensCarrinho.size()) {
                Produto produtoRemovido = itensCarrinho.remove(index);
                quantidadeCarrinho--;
                valorCarrinho -= produtoRemovido.getPreco();
                System.out.println("Produto removido do carrinho: " + produtoRemovido.getNome());
            } else {
                throw new ProdutoIndisponivelException("Produto não encontrado");
            }
        } catch (EstoqueException e) {
            if (itensCarrinho.isEmpty()) {
                System.out.print("Carrinho já está " + e.getMessage());
            }
        }
    }
    
    public void mostrarCarrinho() throws EstoqueException {
        try {
            System.out.println("----SEU CARRINHO----");
            for (Produto produto : itensCarrinho) {
                System.out.println( itensCarrinho.indexOf(produto) + " - " + produto ); // Isso imprimirá cada produto em uma linha separada
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

    @Override
    public String toString() {
        return "Carrinho [itensCarrinho=" + itensCarrinho + ", quantidadeCarrinho=" + quantidadeCarrinho
                + ", valorCarrinho=" + valorCarrinho + "]";
    }

    

}

