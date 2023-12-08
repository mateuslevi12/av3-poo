package excecao;

public class ProdutoIndisponivelException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ProdutoIndisponivelException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "ProdutoIndisponivelException []";
    }
}