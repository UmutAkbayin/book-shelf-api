package dev.akbayin.bookshelfapi.exception;

public class DuplicateBookException extends RuntimeException {
    public DuplicateBookException() {}
    public DuplicateBookException(String message) {
        super(message);
    }

    public DuplicateBookException(String message, Throwable cause) {
        super(message, cause);
    }
}
