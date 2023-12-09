package geral;

import java.time.LocalDate;

public class Pix extends Pagamento{

    public Pix(double valor, LocalDate data) {
        super(valor, data);
    }

    @Override
    public void solicitarPagamento() {
        System.out.println("Chave pix: 123456789");
    }

    @Override
    public void efetuarPagamento() {
        System.out.println("Pagamento efetuado");
        statusPagamento = StatusPagamento.APROVADO;
    }
    
}