package excecao;

public class SaldoInsuficienteException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public SaldoInsuficienteException(String message) {
        super("Saldo Insuficiente");
    }

    @Override
    public String toString() {
        return "SaldoInsuficienteException []";
    }

    
}