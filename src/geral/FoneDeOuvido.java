package geral;

import classesAbstratas.Produto;

public class FoneDeOuvido extends Produto{
    private String tipo;

    public FoneDeOuvido(String nome, double preco, String marca, String tipo) {
        super(nome, preco, marca);
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "FoneDeOuvido";
    }

    public String getTipo() {
        return tipo;
    }
   
}
