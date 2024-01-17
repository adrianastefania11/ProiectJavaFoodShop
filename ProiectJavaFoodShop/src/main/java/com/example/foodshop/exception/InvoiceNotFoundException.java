package com.example.foodshop.exception;

public class InvoiceNotFoundException extends RuntimeException {
    public InvoiceNotFoundException(String message) {
        super(message);
    }
}
