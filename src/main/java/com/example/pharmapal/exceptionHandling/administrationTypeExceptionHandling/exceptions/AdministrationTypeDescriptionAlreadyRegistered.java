package com.example.pharmapal.exceptionHandling.administrationTypeExceptionHandling.exceptions;

public class AdministrationTypeDescriptionAlreadyRegistered extends RuntimeException {
    public AdministrationTypeDescriptionAlreadyRegistered(String message) {
        super(message);
    }

    public AdministrationTypeDescriptionAlreadyRegistered(String message, Throwable cause) {
        super(message, cause);
    }
}

