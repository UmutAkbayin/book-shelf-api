package dev.akbayin.bookshelfapi.exception;

public class BookVersionMismatchException extends RuntimeException {

    public BookVersionMismatchException() {}

    public BookVersionMismatchException(String message) {
        super(message);
    }

    public BookVersionMismatchException(String message, Throwable cause) {
        super(message, cause);
    }
}
