package com.example.parking.AEPB;

public class Ticket {
    private String carToken;

    public Ticket(String carToken) {
        this.carToken = carToken;
    }

    public String getTicketNumber() {
        return carToken;
    }
}
