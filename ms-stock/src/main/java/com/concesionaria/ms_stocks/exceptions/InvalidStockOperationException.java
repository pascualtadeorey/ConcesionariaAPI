package com.concesionaria.ms_stocks.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidStockOperationException extends RuntimeException {
    public InvalidStockOperationException(String message) {
        super(message);
    }
}