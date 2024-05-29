package com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions;

public class ProductFormDescriptionAlreadyRegistered extends RuntimeException {
    public ProductFormDescriptionAlreadyRegistered(String message) {
        super(message);
    }

    public ProductFormDescriptionAlreadyRegistered(String message, Throwable cause) {
        super(message, cause);
    }
}

