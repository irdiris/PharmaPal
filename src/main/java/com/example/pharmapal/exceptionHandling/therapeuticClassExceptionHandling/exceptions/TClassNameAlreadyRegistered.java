package com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions;

public class TClassNameAlreadyRegistered extends RuntimeException {
    public TClassNameAlreadyRegistered(String message) {
        super(message);
    }

    public TClassNameAlreadyRegistered(String message, Throwable cause) {
        super(message, cause);
    }
}

