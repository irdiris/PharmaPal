package com.example.pharmapal.exceptionHandling.commandLineExceptionHandling.exceptions;

public class PathDoesNotExistException  extends  RuntimeException{




        public PathDoesNotExistException(String message) {
            super(message);
        }

        public PathDoesNotExistException(String message, Throwable cause) {
            super(message, cause);
        }
    }

