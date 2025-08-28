package com.concesionaria.ms_cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Los errores de validación de campos son un "Bad Request" (400)
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidFieldException extends RuntimeException {
    public InvalidFieldException(String message) {
        super(message);
    }
}