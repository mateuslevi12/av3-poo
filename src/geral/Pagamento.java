package geral;

import java.time.LocalDate;

public abstract class Pagamento {
    protected double valor;
    protected LocalDate data;
    protected StatusPagamento statusPagamento;

    public Pagamento(double valor) {
        this.valor = valor;
        this.statusPagamento = StatusPagamento.PENDENTE;
    }

    public abstract void solicitarPagamento();

    public abstract void efetuarPagamento();
}
