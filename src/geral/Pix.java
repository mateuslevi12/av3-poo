package geral;

import classesAbstratas.Pagamento;
import excecao.SaldoInsuficienteException;

public class Pix extends Pagamento{
    private Cliente cliente;

    public Pix(double valor, Cliente cliente) {
        super(valor * 0.8);
        this.cliente = cliente;
    }
 
    @Override
    public void solicitarPagamento() throws SaldoInsuficienteException {
        if (cliente.getSaldo() < valor) {
             throw new SaldoInsuficienteException("Saldo insuficiente para realizar a compra");
        }
        System.out.println("Chave pix: 123456789");
        System.out.println("Valor a pagar: " + valor);
    }

    @Override
    public void efetuarPagamento() {
        System.out.println("Pagamento efetuado");
        statusPagamento = StatusPagamento.APROVADO;
    }

    @Override
    public String toString() {
        return "Pix";
    }
    
    
}
