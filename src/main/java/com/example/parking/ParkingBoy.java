package com.example.parking;

import com.example.excepition.InvalidGettingException;

public class ParkingBoy {

    public Ticket parkingBoyParkingCarAndGetTicket(ParkingLotGroup parkingLotGroup, Car car) {
        int parkingLotNo = 0;
        for (ParkingLot parkingLot : parkingLotGroup.getParkingLotList()) {
            if (parkingLot.getParkingLotMap().size() < 50) {
                return parkingLotGroup.parkingCarAndGetTicket(parkingLotNo, car);
            }
            parkingLotNo++;
        }
        return null;
    }

    public Car getCar(ParkingLotGroup parkingLotGroup, Ticket ticket) {
        for (ParkingLot parkingLot : parkingLotGroup.getParkingLotList()) {
            if (parkingLot.getParkingLotMap().containsKey(ticket)) {
                return parkingLot.getParkingLotMap().remove(ticket);
            }
        }
        throw new InvalidGettingException("Unable to take the car.");
    }


}
