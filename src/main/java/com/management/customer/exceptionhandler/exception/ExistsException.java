package com.management.customer.exceptionhandler.exception;

public class ExistsException extends RuntimeException {
    public ExistsException(String message) {
        super(message);
    }
}
