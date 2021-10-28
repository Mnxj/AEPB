package com.example.parking;

import com.example.excepition.InvalidGettingException;
import com.example.excepition.InvalidParkingException;
import com.example.parking.entity.Car;
import com.example.parking.entity.Ticket;

import java.util.HashMap;
import java.util.Map;

import static java.util.Objects.isNull;

public  class ParkingLot  implements Getting,Parking{

    private Map<Ticket, Car> parkingLotMap =new HashMap<>();
    private  int maxParkingCount;


    public ParkingLot(){
        this.maxParkingCount =50;
    }
    public ParkingLot(int maxParkingCount){
        this.maxParkingCount=maxParkingCount;
    }
    @Override
    public Ticket parkingCarAndGetTicket(Car car) {
        if (isNull(car)) {
            throw new InvalidParkingException("You need at least one car to get a ticket.");
        }
        if (maxParkingCount==parkingLotMap.size()) return  null;
        Ticket ticket = new Ticket();
        parkingLotMap.put(ticket, car);
        return ticket;
    }
    @Override
    public Car getCar(Ticket ticket) {
        if (isNull(ticket)) {
            throw new InvalidGettingException("You need at least one car to get a ticket.");
        }
        if (!parkingLotMap.containsKey(ticket)) throw new InvalidGettingException("Unable to take the car.");
        return  parkingLotMap.remove(ticket);
    }

    public boolean checkParkingLotIsFull() {
        return parkingLotMap.size() == maxParkingCount;
    }

    public int getParkingLotRemainCount() {
        return maxParkingCount - parkingLotMap.size();
    }

    public int getMaxParkingCount() {
        return maxParkingCount;
    }
}
