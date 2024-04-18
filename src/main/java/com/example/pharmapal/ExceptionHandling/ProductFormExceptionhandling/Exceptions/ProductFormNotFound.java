package com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions;

public class ProductFormNotFound extends RuntimeException{
    public ProductFormNotFound(String message) {
        super(message);
    }

    public ProductFormNotFound(String message, Throwable cause) {
        super(message, cause);
    }
}
