package geral;

import java.time.LocalDate;

public class Cartao extends Pagamento {
    
    public Cartao(double valor, LocalDate data) {
        super(valor * 1.2, data);
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
