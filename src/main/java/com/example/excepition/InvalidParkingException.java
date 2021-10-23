package com.example.excepition;

public class InvalidParkingException extends RuntimeException {
    public InvalidParkingException(String msg) {
        super(msg);
    }
}
