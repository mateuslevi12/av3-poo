package geral;

import classesAbstratas.Pagamento;
import excecao.SaldoInsuficienteException;

public class Cartao extends Pagamento {
    private int senha;
    private Cliente cliente;

    public Cartao(double valor, int senha, Cliente cliente) {
        super(valor * 1.2);
        this.senha = senha;
        this.cliente = cliente;
    }

    @Override
    public void solicitarPagamento() throws SaldoInsuficienteException{
        if (cliente.getSaldo() < valor) {
            throw new SaldoInsuficienteException("Saldo insuficiente para realizar a compra");
        }
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
