package com.example.pharmapal.ExceptionHandling.TherapeuticClassExceptionHandling.Exceptions;

public class TClassDescriptionAlreadyRegistered extends RuntimeException {
    public TClassDescriptionAlreadyRegistered(String message) {
        super(message);
    }

    public TClassDescriptionAlreadyRegistered(String message, Throwable cause) {
        super(message, cause);
    }
}

