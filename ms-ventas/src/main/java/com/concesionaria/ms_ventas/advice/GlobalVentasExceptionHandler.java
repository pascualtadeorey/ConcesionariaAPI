package com.concesionaria.ms_ventas.advice;

import com.concesionaria.ms_ventas.exception.ResourceNotFoundException;
import com.concesionaria.ms_ventas.exception.SellProcessException;
import com.concesionaria.ms_ventas.exception.ServiceUnavailableException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalVentasExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFound(ResourceNotFoundException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND); // 404
    }

    @ExceptionHandler(SellProcessException.class)
    public ResponseEntity<Map<String, String>> handleSellProcessException(SellProcessException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        // Usamos 400 para errores de reglas de negocio que el cliente podría haber evitado.
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST); // 400
    }
    // <-- PASO 3: AÑADIR ESTE NUEVO MANEJADOR

    @ExceptionHandler(ServiceUnavailableException.class)
    public ResponseEntity<Map<String, String>> handleServiceUnavailable(ServiceUnavailableException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());

        // Devolvemos el código 503 Service Unavailable
        return new ResponseEntity<>(errorResponse, HttpStatus.SERVICE_UNAVAILABLE);
    }
}