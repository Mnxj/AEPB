package com.example.parking;

import com.example.parking.entity.Car;
import com.example.parking.entity.Ticket;

import java.util.Map;

public interface Getting {
    Car getCar(Ticket ticket);

    static Car getCarByTicket(Ticket ticket, Map<String, ParkingLot> parkingLotMap) {
        for (int parkingLotNumber = 1; parkingLotNumber <= parkingLotMap.size(); parkingLotNumber++) {
            ParkingLot parkingLot = parkingLotMap.get(String.valueOf(parkingLotNumber));
            Car car = parkingLot.getCar(ticket);
            parkingLotMap.put(String.valueOf(parkingLotNumber), parkingLot);
            return car;
        }
        return null;
    }
}
