package com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions;

public class ProductFormDescriptionAlreadyRegistered extends RuntimeException {
    public ProductFormDescriptionAlreadyRegistered(String message) {
        super(message);
    }

    public ProductFormDescriptionAlreadyRegistered(String message, Throwable cause) {
        super(message, cause);
    }
}

