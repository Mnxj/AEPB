package com.example.parking;

import com.example.excepition.InvalidParkingException;
import com.example.parking.entity.Car;
import com.example.parking.entity.Ticket;

import java.util.Map;


public class ParkingBoy  implements Getting,Parking{
    private final Map<String, ParkingLot> parkingLotMap;

    public ParkingBoy(Map<String, ParkingLot> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
    }

    @Override
    public Ticket parkingCarAndGetTicket(Car car) {
        Ticket ticket;
        for (int parkingLotNumber = 1; parkingLotNumber <= 10; parkingLotNumber++) {
            ParkingLot parkingLot = parkingLotMap.get(String.valueOf(parkingLotNumber));
            if (!parkingLot.checkParkingLotIsFull()){
                ticket = parkingLot.parkingCarAndGetTicket(car);
                parkingLotMap.put(String.valueOf(parkingLotNumber), parkingLot);
                return ticket;
            }
        }
        throw new InvalidParkingException("parkingLots is full");
    }

    @Override
    public Car getCar(Ticket ticket) {
        return Getting.getCarByTicket(ticket,parkingLotMap);
    }
}
