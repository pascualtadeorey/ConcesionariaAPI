package com.concesionaria.ms_cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Un DNI duplicado es un "Conflicto" (409) con el estado actual del servidor.
@ResponseStatus(HttpStatus.CONFLICT)
public class DuplicateDniException extends RuntimeException {
    public DuplicateDniException(String message) {
        super(message);
    }
}