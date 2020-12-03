package com.poc.exemplos.exceptions;

public class ApiUsuarioException extends RuntimeException {
    public ApiUsuarioException(String message, Exception e) {
        super(message, e);
    }
}
