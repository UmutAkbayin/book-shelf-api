package dev.akbayin.bookshelfapi.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ErrorResponse {
    private final String message;
    private final Map<String, String> errors;
    private final LocalDateTime timestamp;

    public ErrorResponse(String message) {
        this(message, null);
    }

    public ErrorResponse(String message, Map<String, String> errors) {
        this.message = message;
        this.errors = errors;
        this.timestamp = LocalDateTime.now();
    }
}