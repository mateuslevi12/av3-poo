package geral;

import classesAbstratas.Produto;

public class Notebook extends Produto {

    private double tela;
  
    public double getTela() {
        return tela;
    }

    public Notebook(String nome, double preco, String marca,  double tela) {
        super(nome, preco, marca);
        this.tela = tela;
    }

    @Override
    public String toString() {
        return "Notebook";
    }
}
