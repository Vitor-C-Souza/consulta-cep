package exception;

public class CepLenghtInvalidException extends RuntimeException {
    private final String message;

    public CepLenghtInvalidException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
