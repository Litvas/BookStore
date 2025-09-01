package org.litvas.bookstore.controllers;

import jakarta.servlet.ServletException;
import lombok.AllArgsConstructor;
import org.litvas.bookstore.dto.ExceptionResponseDTO;
import org.litvas.bookstore.exceptions.CustomerNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler {


    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ExceptionResponseDTO> handleClientNotFoundException(CustomerNotFoundException ex) {
        ExceptionResponseDTO exceptionResponseDto = new ExceptionResponseDTO(
                String.valueOf(HttpStatus.NOT_FOUND.value()),
                HttpStatus.NOT_FOUND.getReasonPhrase(),
                ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponseDto);
    }

    @ExceptionHandler(ServletException.class)
    public ResponseEntity<ExceptionResponseDTO> handleExceptions(ServletException ex) {
        ExceptionResponseDTO exceptionResponseDto = new ExceptionResponseDTO(
                String.valueOf(HttpStatus.BAD_REQUEST.value()),
                HttpStatus.BAD_REQUEST.getReasonPhrase(),
                ex.getLocalizedMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponseDto);
    }
}
