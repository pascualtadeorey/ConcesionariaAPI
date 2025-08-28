package com.concesionaria.ms_ventas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Usaremos 400 Bad Request para errores lógicos o de validación de negocio.
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class SellProcessException extends RuntimeException {
    public SellProcessException(String message) {
        super(message);
    }
}