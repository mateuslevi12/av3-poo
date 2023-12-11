package leituraEscrita;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import classesAbstratas.Produto;
import geral.Celular;
import geral.FoneDeOuvido;
import geral.Notebook;

public class EscritaEstoque {

    public void escreverEstoque(List<Produto> produtos, String nomeArquivo) throws IOException {
        File arquivo = new File(nomeArquivo);

        FileWriter fw = new FileWriter(arquivo);

        int quantidadeProdutos = produtos.size();
        
        for (int i = 0; i < quantidadeProdutos; i++) {
            Produto produto = produtos.get(i);
            if (produto instanceof Celular) {
                Celular celular = (Celular) produto;
                fw.write("celular ");
                fw.write(celular.getNome() + " ");
                fw.write(celular.getPreco() + " ");
                fw.write(celular.getMarca() + " ");
                fw.write(String.valueOf(celular.getMemoria()));
            } else if (produto instanceof Notebook) {
                Notebook notebook = (Notebook) produto;
                fw.write("notebook ");
                fw.write(notebook.getNome() + " ");
                fw.write(notebook.getPreco() + " ");
                fw.write(notebook.getMarca() + " ");
                fw.write(String.valueOf(notebook.getTela()));
            } else if (produto instanceof FoneDeOuvido) {
                FoneDeOuvido fone = (FoneDeOuvido) produto;
                fw.write("foneDeOuvido ");
                fw.write(fone.getNome() + " ");
                fw.write(fone.getPreco() + " ");
                fw.write(fone.getMarca() + " ");
                fw.write(fone.getTipo());
            }

            // Se não for o último produto, escreve uma quebra de linha
            if (i < quantidadeProdutos - 1) {
                fw.write("\n");
            }
        }
        fw.close();
    }
}
