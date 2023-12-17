package com.example.pharmapal.ExceptionHandling.AdministrationTypeExceptionHandling.Exceptions;

public class AdministrationTypeNameAlreadyRegistered extends RuntimeException {
    public AdministrationTypeNameAlreadyRegistered(String message) {
        super(message);
    }

    public AdministrationTypeNameAlreadyRegistered(String message, Throwable cause) {
        super(message, cause);
    }
}

