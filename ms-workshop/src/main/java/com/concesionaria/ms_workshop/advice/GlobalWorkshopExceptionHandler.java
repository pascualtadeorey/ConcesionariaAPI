package com.concesionaria.ms_workshop.advice;

import com.concesionaria.ms_workshop.Exception.WorkshopException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalWorkshopExceptionHandler {

    @ExceptionHandler(WorkshopException.class)
    public ResponseEntity<Map<String, String>> handleResourceNotFound(WorkshopException ex) {
        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("error", ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND); // 404
    }
}
