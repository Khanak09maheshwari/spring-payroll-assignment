package com.naehas.assignment.customException;

/**
 * define a user defined exception class
 * handle exception if occur
 */
public class RequestNotValidException extends Exception{
    public RequestNotValidException(String message) {
        super(message);
    }

    public RequestNotValidException(String message, Throwable cause) {
        super(message, cause);
    }

    public RequestNotValidException(Throwable cause) {
        super(cause);
    }
}
