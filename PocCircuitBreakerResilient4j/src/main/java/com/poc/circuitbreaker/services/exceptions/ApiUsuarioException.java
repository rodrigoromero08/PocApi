package com.poc.circuitbreaker.services.exceptions;

public class ApiUsuarioException extends RuntimeException {
    public ApiUsuarioException(String message, Exception e) {
        super(message, e);
    }
}
