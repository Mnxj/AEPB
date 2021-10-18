package com.example.parking.AEPB;

public class InvalidParkingException extends RuntimeException {
    public InvalidParkingException(String msg) {
        super(msg);
    }
}
