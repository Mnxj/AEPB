package com.example.parking;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotGroup{
    private final List<ParkingLot> parkingLotList;

    public ParkingLotGroup(){
        parkingLotList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            parkingLotList.add(new ParkingLot());
        }
    }
    public Ticket parkingCarAndGetTicket(int parkingLotNo,Car car) {
        return parkingLotList.get(parkingLotNo).parkingCarAndGetTicket(car);
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }
}
