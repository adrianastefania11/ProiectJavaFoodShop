package com.example.foodshop.exception;

public class BasketNotFoundException extends RuntimeException {
    public BasketNotFoundException(String message) {
        super(message);
    }
}
