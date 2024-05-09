package exception;

public class CepNotFoundException extends RuntimeException {
    private final String message;

    public CepNotFoundException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
