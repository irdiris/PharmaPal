package com.example.pharmapal.ExceptionHandling.StaffShiftsExceptions.Exceptions;

public class StaffAlreadyAssignedToShift extends  RuntimeException{

    public StaffAlreadyAssignedToShift(String message) {
        super(message);
    }

    public StaffAlreadyAssignedToShift(String message, Throwable cause) {
        super(message, cause);
    }
}
