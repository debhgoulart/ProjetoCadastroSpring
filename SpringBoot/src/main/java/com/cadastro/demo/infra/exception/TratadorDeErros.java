package com.cadastro.demo.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity TratarErro404() {
        // erro 404 - not found | servidor não encontrou uma representação atual do recurso solicitado
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity TratarErro400(MethodArgumentNotValidException exception) {
        // erro 400 - bad request | dados inválidos ou não existentes

        var erros = exception.getFieldErrors();

        return ResponseEntity.badRequest().body(erros);
    }
}
