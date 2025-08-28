package com.concesionaria.ms_vendedor.advice;

import com.concesionaria.ms_vendedor.exception.SellerException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * Esta clase actúa como un interceptor global de excepciones para toda la aplicación.
 * La anotación @ControllerAdvice permite manejar excepciones a través de todo
 * el sistema en un solo componente global.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Este método se ejecutará cada vez que un controlador lance una SellerException.
     * @param ex La excepción que fue lanzada.
     * @return Una respuesta HTTP formateada (ResponseEntity).
     */
    @ExceptionHandler(SellerException.class)
    public ResponseEntity<Map<String, String>> handleSellerException(SellerException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());

        // Creamos una respuesta con:
        // 1. El cuerpo (body) que es nuestro mapa con el mensaje de error.
        // 2. El código de estado HTTP 404 NOT_FOUND.
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}