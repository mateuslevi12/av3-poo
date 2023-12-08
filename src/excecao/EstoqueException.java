
public class EstoqueException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public EstoqueException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "EstoqueException []";
    }
}