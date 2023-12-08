package geral;

public class Cliente extends Pessoa{
    
    private double saldo;

    public Cliente(String nome, String idade, String email, int numeroDeTelefone, double saldo) {
        super(nome, idade, email, numeroDeTelefone);
        this.saldo = saldo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "Cliente: " + getNome() + "saldo= " + saldo;
    }

    
    
}