package geral;

import classesAbstratas.Produto;

public class Celular extends Produto {
    private double memoria;

    public double getMemoria() {
        return memoria;
    }

    public Celular(String nome, double preco, String marca, double memoria) {
        super(nome, preco, marca);
        this.memoria = memoria;
    }
 
    @Override
    public String toString() {
        return "Celular";
    }

}
