package geral;

public class Notebook extends Produto {
  
    public Notebook(String nome, double preco, String marca) {
        super(nome, preco, marca);
       
    }

    @Override
    public String toString() {
        return "Notebook";
    }

    
    
}
