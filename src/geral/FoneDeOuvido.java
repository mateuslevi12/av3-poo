package geral;

public class FoneDeOuvido extends Produto{
    private String tipoConexao; 
    private String tipoFone; 
    private boolean microfone; 
    private String cor;

    public FoneDeOuvido(String nome, double preco, String marca, String descricao, String tipoConexao, String tipoFone, boolean microfone, String cor) {
        super(nome, preco, marca, descricao);
        this.tipoConexao = tipoConexao;
        this.tipoFone = tipoFone;
        this.microfone = microfone;
        this.cor = cor;
    }

    public String getTipoConexao() {
        return tipoConexao;
    }

    public void setTipoConexao(String tipoConexao) {
        this.tipoConexao = tipoConexao;
    }

    public String getTipoFone() {
        return tipoFone;
    }

    public void setTipoFone(String tipoFone) {
        this.tipoFone = tipoFone;
    }

    public boolean isMicrofone() {
        return microfone;
    }

    public void setMicrofone(boolean microfone) {
        this.microfone = microfone;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "FoneDeOuvido ";
    }

    @Override
    public String mostrarDetalhesProduto() {
        return "FoneDeOuvido [tipoConexao=" + tipoConexao + ", tipoFone=" + tipoFone + ", microfone=" + microfone
                + ", cor=" + cor + "]";
    }

    
    
}
