package com.exceptions;

public class DriverInitializationException extends RuntimeException {

    // user defined exception
    public DriverInitializationException(String message) {
        super(message);
    }

    public DriverInitializationException(String message, Throwable t) {
        super(message, t);
    }
}