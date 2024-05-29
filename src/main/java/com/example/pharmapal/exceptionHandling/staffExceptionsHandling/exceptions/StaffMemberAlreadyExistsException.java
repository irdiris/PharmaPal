package com.example.pharmapal.exceptionHandling.staffExceptionsHandling.exceptions;

public class StaffMemberAlreadyExistsException  extends  RuntimeException{

    public StaffMemberAlreadyExistsException(String message) {
        super(message);
    }

    public StaffMemberAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
