package com.example.pharmapal.exceptionHandling.administrationTypeExceptionHandling.exceptions;

public class AdministrationTypeNameAlreadyRegistered extends RuntimeException {
    public AdministrationTypeNameAlreadyRegistered(String message) {
        super(message);
    }

    public AdministrationTypeNameAlreadyRegistered(String message, Throwable cause) {
        super(message, cause);
    }
}

