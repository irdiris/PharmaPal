package com.example.pharmapal.exceptionHandling.stockedProductsExceptionHandling.exceptions;

public class ExpirationDateOutOfRange extends RuntimeException{
    public ExpirationDateOutOfRange(String message) {
        super(message);
    }

    public ExpirationDateOutOfRange(String message, Throwable cause) {
        super(message, cause);
    }
}
