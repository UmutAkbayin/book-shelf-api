package dev.akbayin.bookshelfapi.exception;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Map;

@Data
public class ErrorResponse {
    private final String message;
    private String errorCode;
    private final LocalDateTime timestamp;

    public ErrorResponse(String message) {
        this(message, null);
    }

    public ErrorResponse(String message, String errorCode) {
        this.message = message;
        this.errorCode = errorCode;
        this.timestamp = LocalDateTime.now();
    }
}