package com.example.exception;

public class QRcodeNotFoundException extends RuntimeException {
    public QRcodeNotFoundException(String message) {
        super(message);
    }
}
