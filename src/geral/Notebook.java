package geral;

public class Notebook extends Produto {
    private String processador;
    private int ram;
    private int armazenamento;
    private String sistemaOperacional;

    public Notebook(String nome, double preco, String marca, String descricao, String processador, int ram, int armazenamento, String sistemaOperacional) {
        super(nome, preco, marca, descricao);
        this.processador = processador;
        this.ram = ram;
        this.armazenamento = armazenamento;
        this.sistemaOperacional = sistemaOperacional;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getArmazenamento() {
        return armazenamento;
    }

    public void setArmazenamento(int armazenamento) {
        this.armazenamento = armazenamento;
    }

    public String getSistemaOperacional() {
        return sistemaOperacional;
    }

    public void setSistemaOperacional(String sistemaOperacional) {
        this.sistemaOperacional = sistemaOperacional;
    }

    @Override
    public String toString() {
        return "Notebook";
    }

    
    
}
