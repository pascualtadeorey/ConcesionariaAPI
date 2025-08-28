package com.concesionaria.ms_concesionaria.advice;

import com.concesionaria.ms_concesionaria.exception.DealershipException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DealershipException.class)
    public ResponseEntity<Map<String, String>> handleClientException(DealershipException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());

        // Cuando no se encuentre una concesionaria, devolveremos un 404 NOT_FOUND
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
}
