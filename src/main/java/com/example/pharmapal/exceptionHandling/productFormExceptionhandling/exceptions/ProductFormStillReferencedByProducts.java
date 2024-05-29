package com.example.pharmapal.exceptionHandling.productFormExceptionhandling.exceptions;

public class ProductFormStillReferencedByProducts extends RuntimeException {
    public ProductFormStillReferencedByProducts(String message) {
        super(message);
    }

    public ProductFormStillReferencedByProducts(String message, Throwable cause) {
        super(message, cause);
    }
}
