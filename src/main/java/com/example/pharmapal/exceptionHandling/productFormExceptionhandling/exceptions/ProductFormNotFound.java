package com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions;

public class ProductFormNotFound extends RuntimeException{
    public ProductFormNotFound(String message) {
        super(message);
    }

    public ProductFormNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
