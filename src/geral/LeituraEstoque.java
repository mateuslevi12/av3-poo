package geral;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class LeituraEstoque {
    private List<Produto> itensEstoque;

    public LeituraEstoque() {
        this.itensEstoque = new ArrayList<Produto>();
    }
    
    public List<Produto> getItensEstoque() {
        return itensEstoque;
    }

    public void efeituarLeritura(String filename) throws FileNotFoundException {
        File f = new File(filename);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()){
             String produto = sc.next();
             if(produto.equals("celular")){
                String nome = sc.next();
                double preco = sc.nextDouble();
                String marca = sc.next();
                Produto celular = new Celular(nome, preco, marca);
                itensEstoque.add(celular);
             }else if(produto.equals("notebook")){
                String nome = sc.next();
                double preco = sc.nextDouble();
                String marca = sc.next();
                Produto notebook = new Notebook(nome, preco, marca);
                itensEstoque.add(notebook);
             } else if(produto.equals("foneDeOuvido")){
                String nome = sc.next();
                double preco = sc.nextDouble();
                String marca = sc.next();
                Produto fone = new FoneDeOuvido(nome, preco, marca);
                itensEstoque.add(fone);
             }
        }
        Estoque estoque = new Estoque();
        estoque.setItensEstoque(itensEstoque);
        sc.close();
    }

}
