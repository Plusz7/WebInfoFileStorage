package com.exercise.storage.exceptions;

public class DbFileNotFoundException extends RuntimeException {

    public DbFileNotFoundException(String message) {
        super(message);
    }
}
