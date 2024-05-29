package com.example.pharmapal.exceptionHandling.shiftsExceptionHandling.exceptions;

public class ShiftAlreadyExistsException extends  RuntimeException{
    public ShiftAlreadyExistsException(String message) {
        super(message);
    }

    public ShiftAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
