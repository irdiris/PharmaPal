package com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions;

public class AdministrationTypeStillReferencedByProducts extends RuntimeException {
    public AdministrationTypeStillReferencedByProducts(String message) {
        super(message);
    }

    public AdministrationTypeStillReferencedByProducts(String message, Throwable cause) {
        super(message, cause);
    }
}
