package com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions;

public class ProductFormNameAlreadyRegistered extends RuntimeException {
    public ProductFormNameAlreadyRegistered(String message) {
        super(message);
    }

    public ProductFormNameAlreadyRegistered(String message, Throwable cause) {
        super(message, cause);
    }
}

