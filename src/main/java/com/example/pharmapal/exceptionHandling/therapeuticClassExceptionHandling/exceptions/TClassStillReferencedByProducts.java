package com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions;

public class TClassStillReferencedByProducts extends RuntimeException {
    public TClassStillReferencedByProducts(String message) {
        super(message);
    }

    public TClassStillReferencedByProducts(String message, Throwable cause) {
        super(message, cause);
    }
}
