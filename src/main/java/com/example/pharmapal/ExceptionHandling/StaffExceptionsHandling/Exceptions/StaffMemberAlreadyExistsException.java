package com.example.pharmapal.ExceptionHandling.StaffExceptionsHandling.Exceptions;

public class StaffMemberAlreadyExistsException  extends  RuntimeException{

    public StaffMemberAlreadyExistsException(String message) {
        super(message);
    }

    public StaffMemberAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }
}
