package com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling;

import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassDescriptionAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassNameAlreadyRegistered;
import com.example.pharmapal.exceptionHandling.therapeuticClassExceptionHandling.exceptions.TClassStillReferencedByProducts;
import com.example.pharmapal.exceptionHandling.ThrownException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class TherapeuticClassExceptionHandlingController {
    @ExceptionHandler(value = TClassNameAlreadyRegistered.class)
    public ResponseEntity<Object> TClassNameAlreadyRegistered (TClassNameAlreadyRegistered e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = TClassDescriptionAlreadyRegistered.class)
    public ResponseEntity<Object> TClassNameAlreadyRegistered (TClassDescriptionAlreadyRegistered e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(value = TClassStillReferencedByProducts.class)
    public ResponseEntity<Object> CLassStillReferencedByProduct (TClassStillReferencedByProducts e){
        ThrownException thrownException =       new ThrownException (
                e.getMessage(),
                e,
                LocalDateTime.now(),
                HttpStatus.CONFLICT
        );
        return new  ResponseEntity<>( thrownException, HttpStatus.BAD_REQUEST);
    }



}
