package com.concesionaria.ms_cliente.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Esta anotación hará que Spring devuelva un 404 Not Found por defecto si no es manejada
@ResponseStatus(HttpStatus.NOT_FOUND)
public class ClientException extends RuntimeException {
    public ClientException(String message) {
        super(message);
    }
}