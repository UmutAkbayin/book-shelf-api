package dev.akbayin.bookshelfapi.exception;

public class InvalidBookArgumentException extends RuntimeException {

    public InvalidBookArgumentException () {}

    public InvalidBookArgumentException(String message) {
        super(message);
    }

    public InvalidBookArgumentException(String message, Throwable cause) {
        super(message, cause);
    }
}
