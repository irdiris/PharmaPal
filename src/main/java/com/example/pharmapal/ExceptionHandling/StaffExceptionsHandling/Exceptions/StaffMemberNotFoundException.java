package com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions;

public class StaffMemberNotFoundException extends RuntimeException {

    public StaffMemberNotFoundException(String message) {
        super(message);
    }

    public StaffMemberNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
