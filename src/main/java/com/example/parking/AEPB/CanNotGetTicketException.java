package com.example.parking.AEPB;

public class CanNotGetTicketException extends RuntimeException {
    public CanNotGetTicketException(String msg) {
        super(msg);
    }
}
