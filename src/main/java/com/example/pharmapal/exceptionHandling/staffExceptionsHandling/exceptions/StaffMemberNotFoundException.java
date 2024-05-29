package com.example.pharmapal.exceptionHandling.staffExceptionsHandling.exceptions;

public class StaffMemberNotFoundException extends RuntimeException {

    public StaffMemberNotFoundException(String message) {
        super(message);
    }

    public StaffMemberNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
