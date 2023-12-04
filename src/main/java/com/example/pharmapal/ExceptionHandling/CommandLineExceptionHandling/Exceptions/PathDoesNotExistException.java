package com.example.pharmapal.ExceptionHandling.CommandLineExceptionHandling.Exceptions;

public class PathDoesNotExistException  extends  RuntimeException{




        public PathDoesNotExistException(String message) {
            super(message);
        }

        public PathDoesNotExistException(String message, Throwable cause) {
            super(message, cause);
        }
    }

