package com.example.pharmapal.ExceptionHandling.ProductFormExceptionhandling.Exceptions;

public class ProductFormStillReferencedByProducts extends RuntimeException {
    public ProductFormStillReferencedByProducts(String message) {
        super(message);
    }

    public ProductFormStillReferencedByProducts(String message, Throwable cause) {
        super(message, cause);
    }
}
