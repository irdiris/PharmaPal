package com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions;

public class TClassNotFound extends RuntimeException{
    public TClassNotFound(String message) {
        super(message);
    }

    public TClassNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
