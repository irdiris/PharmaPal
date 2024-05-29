package com.example.pharmapal.exceptionHandling.lendsExceptionHandling.exceptions;

public class LendDoesNotExistException extends  RuntimeException{




        public LendDoesNotExistException(String message) {
            super(message);
        }

        public LendDoesNotExistException(String message, Throwable cause) {
            super(message, cause);
        }
    }

