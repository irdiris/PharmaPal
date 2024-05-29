package com.example.pharmapal.exceptionHandling.staffShiftsExceptions.exceptions;

public class   ShiftIsNotAssigned extends  RuntimeException{

    public ShiftIsNotAssigned(String message) {
        super(message);
    }

    public ShiftIsNotAssigned(String message, Throwable cause) {
        super(message, cause);
    }
}
