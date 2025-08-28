package com.concesionaria.ms_cliente.advice;

import com.concesionaria.ms_cliente.exception.ClientException;
import com.concesionaria.ms_cliente.exception.DuplicateDniException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ClientException.class)
    public ResponseEntity<Map<String, String>> handleClientException(ClientException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());

        // Cuando no se encuentre un cliente, devolveremos un 404 NOT_FOUND
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    // Es una buena práctica tener un manejador para cualquier otra excepción no esperada
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Map<String, String>> handleGeneralException(Exception ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", "Ha ocurrido un error inesperado en el servicio de Cliente.");
        // Devolvemos un 500 para errores internos del servidor
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(DuplicateDniException.class)
    public ResponseEntity<Map<String, String>> handleDuplicateDniException(DuplicateDniException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        // Para un recurso duplicado, el estado correcto es 409 CONFLICT
        return new ResponseEntity<>(errorResponse, HttpStatus.CONFLICT);
    }

}