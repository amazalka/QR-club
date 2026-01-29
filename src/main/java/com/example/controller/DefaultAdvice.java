package com.example.controller;

import com.example.exception.ParticipantNotFoundException;
import com.example.exception.QRcodeNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class DefaultAdvice  {
    @ExceptionHandler(ParticipantNotFoundException.class)
    public ResponseEntity<String> handleParticipantNotFound(ParticipantNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(QRcodeNotFoundException.class)
    public ResponseEntity<String> handleQRNotFound(QRcodeNotFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
