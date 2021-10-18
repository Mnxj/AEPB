package com.example.parking.AEPB;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class ParkingLot {

    private Map<Ticket, Car> parkingLotMap = new HashMap<>();
    private static final int MAX_PARKING_COUNT = 50;


    public Ticket parkingCarAndGetTicket(Car car) {
        if (isNull(car)) {
            throw new CarNotException("You need at least one car to get a ticket.");
        }
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

    public void getCar(Ticket ticket) {
        if (!parkingLotMap.containsKey(ticket)) throw new CarNotException("Unable to take the car.");
        parkingLotMap.remove(ticket);
    }
}
