package geral;

import classesAbstratas.Pagamento;

public class Cartao extends Pagamento {
    
    public Cartao(double valor) {
        super(valor * 1.2);
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
}
