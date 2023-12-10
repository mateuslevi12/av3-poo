package leituraEscrita;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import classesAbstratas.Produto;
import geral.*;
import interfaces.GerenciamentoNotaFiscal;

public class EscritaNotaFiscal extends Carrinho implements GerenciamentoNotaFiscal{
    private Carrinho carrinho;
    private Cliente cliente;

    public EscritaNotaFiscal(Carrinho carrinho, Cliente cliente) {
        this.carrinho = carrinho;
        this.cliente = cliente;
    }

    @Override
    public void efetuaEscrita(String filename) throws IOException {
        File f = new File(filename);
        FileWriter fw = new FileWriter(f);
        fw.write("--------NOTA FISCAL--------\n");
        fw.write("\n");
        fw.write("NOME DO CLIENTE :" + cliente.getNome());
        fw.write("\n");
        fw.write("EMAIL DO CLIENTE :" + cliente.getEmail());
        fw.write("\n");
        fw.write("\n");

        fw.write("--------PRODUTOS--------\n");
        for (int i = 0; i < carrinho.getItensCarrinho().size(); i++) {
            Produto produto = carrinho.getItensCarrinho().get(i);
            if (produto instanceof Celular) {
                Celular celular = (Celular) produto;
                fw.write("item:" + celular.getNome() + " | valor: 2000.00\n");
            } else if (produto instanceof Notebook) {
                Notebook notebook = (Notebook) produto;
                fw.write("item:" + notebook.getNome() + " | valor: 4000.00\n");
            } else if (produto instanceof FoneDeOuvido) {
                FoneDeOuvido fone = (FoneDeOuvido) produto;
                fw.write("item: " + fone.getNome() + " | valor: 400.00\n");
            }
            fw.write("valor final: " + cliente.getCarrinho().getValorCarrinho());
        }
        fw.write("\n");
        fw.close();
    }
}
