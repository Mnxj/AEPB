package com.example.parking;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SmartParkingBoy {
    public Ticket smartParkingBoyParkingCarAndGetTicket(ParkingLotGroup parkingLotGroup, Car car) {
        List<ParkingLot> parkingLotList = new ArrayList<>(parkingLotGroup.getParkingLotList());
        parkingLotList.sort(Comparator.comparingInt(p -> p.getParkingLotMap().size()));
        int parkingLotNo=0;
        for (ParkingLot parkingLot:parkingLotGroup.getParkingLotList()){
            if (parkingLot.equals(parkingLotList.get(0))){
                return parkingLotGroup.parkingCarAndGetTicket(parkingLotNo, car);
            }
            parkingLotNo++;
        }
        return null;
    }
    public Car getCar(ParkingLotGroup parkingLotGroup, Ticket ticket) {
        return parkingLotGroup.getCar(ticket);
    }
}
