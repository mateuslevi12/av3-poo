package excecao;

public class ProdutoIndisponivelException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ProdutoIndisponivelException(String message) {
        super("indisponivel");
    }

    @Override
    public String toString() {
        return "ProdutoIndisponivelException []";
    }
}