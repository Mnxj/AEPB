package com.example.parking;

public class InvalidParkingException extends RuntimeException {
    public InvalidParkingException(String msg) {
        super(msg);
    }
}
