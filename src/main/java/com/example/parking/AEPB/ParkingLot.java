package com.example.parking.AEPB;

import java.util.HashMap;
import java.util.Map;

public class ParkingLot {

    private Map<Ticket, Car> parkingLotMap = new HashMap<>();
    private static final int MAX_PARKING_COUNT = 50;


    public Ticket parkingCarAndGetTicket(Car car) {
        if (MAX_PARKING_COUNT==parkingLotMap.size()) return  null;
        Ticket ticket = new Ticket(String.valueOf(car.hashCode()));
        parkingLotMap.put(ticket, car);
        return ticket;
    }

    public int getTicketCount() {
        return parkingLotMap.size();
    }

    public int getParkingLotSpace() {
        return MAX_PARKING_COUNT - getTicketCount();
    }
}
