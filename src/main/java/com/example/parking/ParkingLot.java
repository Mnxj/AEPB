package com.example.parking;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public class ParkingLot {

    private Map<Ticket, Car> parkingLotMap ;
    private static final int MAX_PARKING_COUNT = 50;

    public ParkingLot(){
        parkingLotMap = new HashMap<>(MAX_PARKING_COUNT);
    }
    public Ticket parkingCarAndGetTicket(Car car) {
        if (isNull(car)) {
            throw new InvalidParkingException("You need at least one car to get a ticket.");
        }
        if (MAX_PARKING_COUNT==parkingLotMap.size()) return  null;
        Ticket ticket = new Ticket();
        parkingLotMap.put(ticket, car);
        return ticket;
    }

    public Car getCar(Ticket ticket) {
        if (!parkingLotMap.containsKey(ticket)) throw new InvalidGettingException("Unable to take the car.");
        return  parkingLotMap.remove(ticket);
    }
}
