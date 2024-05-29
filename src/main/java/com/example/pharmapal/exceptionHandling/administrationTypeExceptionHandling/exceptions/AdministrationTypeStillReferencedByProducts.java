package com.example.pharmapal.exceptionHandling.administrationTypeExceptionHandling.exceptions;

public class AdministrationTypeStillReferencedByProducts extends  RuntimeException {
    public AdministrationTypeStillReferencedByProducts(String message) {
        super(message);
    }

    public AdministrationTypeStillReferencedByProducts(String message, Throwable cause) {
        super(message, cause);
    }
}
