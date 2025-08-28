package com.concesionaria.ms_concesionaria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DealershipException extends RuntimeException {
    public DealershipException(String message) {
        super(message);
    }
}
