package geral;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EscritaNotaFiscal extends Carrinho{
    private Carrinho carrinho;

    public EscritaNotaFiscal(Carrinho carrinho) {
        this.carrinho = carrinho;
    }

      public void efetuaEscrita(String filename) throws IOException {
		File f = new File(filename);
		FileWriter fw = new FileWriter(f);
		fw.write("--------NOTA FISCAL--------\n");
		fw.write("\n");
		fw.write("--------PRODUTOS--------\n");
        for (int i = 0; i < carrinho.getItensCarrinho().size(); i++) {
            Produto produto = carrinho.getItensCarrinho().get(i);
            if(produto instanceof Celular){
                fw.write("item: Celular | valor: 2000.00\n");
            }else if(produto instanceof Notebook){
                 fw.write("item: Notebook | valor: 4000.00\n");
                } else if(produto instanceof FoneDeOuvido){
                 fw.write("item: Fone De Ouvido | valor: 400.00\n");
             }
           

              
        }
		fw.write("\n");
		fw.close();
	}
}
