package com.example.parking;

public class InvalidGettingException extends RuntimeException {
    public InvalidGettingException(String msg) {
        super(msg);
    }
}
