package com.example.pharmapal.ExceptionHandling.StaffShiftsExceptions.Exceptions;

public class   ShiftIsNotAssigned extends  RuntimeException{

    public ShiftIsNotAssigned(String message) {
        super(message);
    }

    public ShiftIsNotAssigned(String message, Throwable cause) {
        super(message, cause);
    }
}
