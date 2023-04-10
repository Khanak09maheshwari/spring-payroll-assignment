package com.naehas.assignment.exceptionHandler;

import com.naehas.assignment.customException.RequestNotValidException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    //Add an exception handler using @ExceptionHandler to handle all type of exception

    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(RuntimeException e){
        //create a StudentErrorResponse
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<EmployeeErrorResponse> handleException(RequestNotValidException e){
        //create a StudentErrorResponse
        EmployeeErrorResponse error = new EmployeeErrorResponse();
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(e.getMessage());
        error.setTimeStamp(System.currentTimeMillis());

        //return ResponseEntity
        return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
    }


}
