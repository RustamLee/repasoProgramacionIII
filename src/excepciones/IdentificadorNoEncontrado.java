package excepciones;

public class IdentificadorNoEncontrado extends RuntimeException {
    public IdentificadorNoEncontrado(String message) {
        super(message);
    }
}
