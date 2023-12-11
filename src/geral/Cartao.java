package geral;

import classesAbstratas.Pagamento;

public class Cartao extends Pagamento {
    private int senha;

    public Cartao(double valor, int senha) {
        super(valor * 1.2);
        this.senha = senha;
    }

    @Override
    public void solicitarPagamento() {
       System.out.println("Valor a pagar: " + valor);
    }

    @Override
    public void efetuarPagamento() {
        System.out.println("Pagamento efetuado");
        statusPagamento = StatusPagamento.APROVADO;
    }

    @Override
    public String toString() {
        return "Cartao [senha=" + senha + "]";
    }

    
}
