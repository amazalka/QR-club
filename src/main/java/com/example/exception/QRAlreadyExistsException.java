package com.example.exception;

public class QRAlreadyExistsException extends RuntimeException {
    public QRAlreadyExistsException(String message) {
        super(message);
    }
}
