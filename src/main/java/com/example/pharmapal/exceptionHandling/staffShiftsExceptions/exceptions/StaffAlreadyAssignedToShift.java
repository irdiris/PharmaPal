package com.example.pharmapal.exceptionHandling.staffShiftsExceptions.exceptions;

public class StaffAlreadyAssignedToShift extends  RuntimeException{

    public StaffAlreadyAssignedToShift(String message) {
        super(message);
    }

    public StaffAlreadyAssignedToShift(String message, Throwable cause) {
        super(message, cause);
    }
}
