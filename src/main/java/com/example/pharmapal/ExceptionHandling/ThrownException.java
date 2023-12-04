package com.example.pharmapal.ExceptionHandling;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Date;

public class ThrownException {
    private final String message;
    private final Throwable throwable;
    private final LocalDateTime localDateTime;
    private final HttpStatus httpStatus;

    public ThrownException(String message, Throwable throwable, LocalDateTime localDateTime, HttpStatus httpStatus) {
        this.message = message;
        this.throwable = throwable;
        this.localDateTime = localDateTime;
        this.httpStatus = httpStatus;
    }

    public String getMessage() {
        return message;
    }

    public Throwable getThrowable() {
        return throwable;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
}

