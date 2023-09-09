package io.github.mrspock182.mockapi.exception;

public class ApplicationErrorException extends RuntimeException {
    public ApplicationErrorException() {
    }

    public ApplicationErrorException(String message) {
        super(message);
    }

    public ApplicationErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ApplicationErrorException(Throwable cause) {
        super(cause);
    }
}
