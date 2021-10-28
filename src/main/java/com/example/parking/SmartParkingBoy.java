package com.example.parking;

import com.example.excepition.InvalidParkingException;
import com.example.parking.entity.Car;
import com.example.parking.entity.Ticket;

import java.util.Map;

public class SmartParkingBoy  implements Getting,Parking{
    private Map<String, ParkingLot> parkingLotMap;
    public SmartParkingBoy() {
    }
    public SmartParkingBoy(Map<String, ParkingLot> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
    }

    @Override
    public Ticket parkingCarAndGetTicket(Car car) {
        int mostParkingLotNumber = getTheMostAvailableParkingLot();
        if (parkingLotMap.get(String.valueOf(mostParkingLotNumber)).checkParkingLotIsFull()) {
            throw new InvalidParkingException("The parkingLot is full, can not parking any car.");
        }
        ParkingLot parkingLot = parkingLotMap.get(String.valueOf(mostParkingLotNumber));
        Ticket ticket = parkingLot.parkingCarAndGetTicket(car);
        return ticket;
    }

    @Override
    public Car getCar(Ticket ticket) {
        return Getting.getCarByTicket(ticket,parkingLotMap);
    }

    private int getTheMostAvailableParkingLot() {
        int mostParkingNumber = 1;
        for (int parkingLotNumber = 2; parkingLotNumber <= 10; parkingLotNumber++) {
            if (parkingLotMap.get(String.valueOf(mostParkingNumber)).getParkingLotRemainCount()
                    < parkingLotMap.get(String.valueOf(parkingLotNumber)).getParkingLotRemainCount()) {
                mostParkingNumber = parkingLotNumber;
            }
        }
        return mostParkingNumber;
    }
}
