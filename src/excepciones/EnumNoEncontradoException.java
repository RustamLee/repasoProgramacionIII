package excepciones;

public class EnumNoEncontradoException extends RuntimeException {
    public EnumNoEncontradoException(String message) {
        super(message);
    }
}
