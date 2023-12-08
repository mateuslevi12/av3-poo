package geral;

public class Celular extends Produto {
    private String modelo;
    private String sistemaOperacional;
    private int armazenamento;
    private double tamanhoTela;
    
    public Celular(String nome, double preco, String marca, String descricao, String modelo, String sistemaOperacional, int armazenamento, double tamanhoTela) {
        super(nome, preco, marca, descricao);
        this.modelo = modelo;
        this.sistemaOperacional = sistemaOperacional;
        this.armazenamento = armazenamento;
        this.tamanhoTela = tamanhoTela;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public double getTamanhoTela() {
        return tamanhoTela;
    }

    public void setTamanhoTela(double tamanhoTela) {
        this.tamanhoTela = tamanhoTela;
    }

    @Override
    public String toString() {
        return "Celular";
    }

    @Override
    public String mostrarDetalhesProduto() {
        return "Notebook [modelo=" + modelo + ", armazenamento=" + armazenamento + ", sistema operacional=" + sistema operacional
        + ", tamanhoTela=" + tamanhoTela + "]";
    }

    
}
