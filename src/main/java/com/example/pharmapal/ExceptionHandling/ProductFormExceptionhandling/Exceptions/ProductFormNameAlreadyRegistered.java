package com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions;

public class ProductFormNameAlreadyRegistered extends RuntimeException {
    public ProductFormNameAlreadyRegistered(String message) {
        super(message);
    }

    public ProductFormNameAlreadyRegistered(String message, Throwable cause) {
        super(message, cause);
    }
}

