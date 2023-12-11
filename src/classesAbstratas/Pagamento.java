package classesAbstratas;

import geral.StatusPagamento;

public abstract class Pagamento {
    protected double valor;
    protected StatusPagamento statusPagamento;

    public Pagamento(double valor) {
        this.valor = valor;
        this.statusPagamento = StatusPagamento.PENDENTE;
    }

    public abstract void solicitarPagamento();

    public abstract void efetuarPagamento();

    @Override
    public String toString() {
        return "Pagamento [valor=" + valor + ", statusPagamento=" + statusPagamento + "]";
    }

    
}
