package classesAbstratas;

// nao é possivel instanciar um produto
public abstract class Produto {
    protected String nome;
    protected double preco;
    protected String marca;

    public Produto(String nome, double preco, String marca) {
        this.nome = nome;
        this.preco = preco;
        this.marca = marca;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public String getMarca() {
        return marca;
    }

    @Override
    public String toString() {
        return "Produto [nome=" + nome + ", preco=" + preco + ", marca=" + marca + "]";
    }    
    
}
