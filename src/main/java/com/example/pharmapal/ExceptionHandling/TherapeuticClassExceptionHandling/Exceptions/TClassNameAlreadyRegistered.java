package com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions;

public class TClassNameAlreadyRegistered extends RuntimeException {
    public TClassNameAlreadyRegistered(String message) {
        super(message);
    }

    public TClassNameAlreadyRegistered(String message, Throwable cause) {
        super(message, cause);
    }
}

