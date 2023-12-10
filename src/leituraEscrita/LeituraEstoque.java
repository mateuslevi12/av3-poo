package leituraEscrita;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import classesAbstratas.Produto;
import geral.*;

import java.util.Locale;
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
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(f);
        while (sc.hasNextLine()){
             String produto = sc.next();
             if(produto.equals("celular")){
                String nome = sc.next();
                double preco = sc.nextDouble();
                String marca = sc.next();
                double memoria = sc.nextDouble();
                Produto celular = new Celular(nome, preco, marca, memoria);
                itensEstoque.add(celular);
                
             }else if(produto.equals("notebook")){
                String nome = sc.next();
                double preco = sc.nextDouble();
                String marca = sc.next();
                double tela = sc.nextDouble();
                Produto notebook = new Notebook(nome, preco, marca, tela);
                itensEstoque.add(notebook);

             } else if(produto.equals("foneDeOuvido")){
                String nome = sc.next();
                double preco = sc.nextDouble();
                String marca = sc.next();
                String tipo = sc.next();
                Produto fone = new FoneDeOuvido(nome, preco, marca, tipo);
                itensEstoque.add(fone);
             }
        }
        Estoque estoque = new Estoque();
        estoque.setItensEstoque(itensEstoque);
        sc.close();
    }

}
