package com.example.pharmapal.exceptionHandling.shiftsExceptionHandling.exceptions;

public class ShiftNotFoundException extends  RuntimeException{
    public ShiftNotFoundException(String message) {
        super(message);
    }

    public ShiftNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
