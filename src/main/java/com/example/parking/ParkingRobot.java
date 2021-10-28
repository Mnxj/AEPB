package com.example.parking;

import com.example.excepition.InvalidGettingException;
import com.example.excepition.InvalidParkingException;
import com.example.parking.entity.Car;
import com.example.parking.entity.Ticket;

import java.util.Map;

public class ParkingRobot implements ParkAndGet{
    private Map<String, ParkingLot> parkingLotMap;

    public ParkingRobot(Map<String, ParkingLot> parkingLotMap) {
        this.parkingLotMap = parkingLotMap;
    }

    @Override
    public Ticket parkingCarAndGetTicket(Car car) {
        int mostParkingLotNumber = getTheBiggestVacancyRateParkingLot();
        if (parkingLotMap.get(String.valueOf(mostParkingLotNumber)).checkParkingLotIsFull()) {
            throw new InvalidParkingException("The parkingLot is full, can not parking any car.");
        }
        ParkingLot parkingLot = parkingLotMap.get(String.valueOf(mostParkingLotNumber));
        return parkingLot.parkingCarAndGetTicket(car);
    }

    @Override
    public Car getCar(Ticket ticket) {
        throw new InvalidGettingException("Parking Robot Disabled Pike Up Car!!!!!!");
    }

    private int getTheBiggestVacancyRateParkingLot() {
        int biggestVacancyRateParkingLotNumber = 1;
        for (int parkingLotNumber = 2; parkingLotNumber <= parkingLotMap.size(); parkingLotNumber++) {
            ParkingLot biggestParkingLot = parkingLotMap.get(String.valueOf(biggestVacancyRateParkingLotNumber));
            ParkingLot comparedParkingLot = parkingLotMap.get(String.valueOf(parkingLotNumber));

            if (calculateTheVacancyRate(biggestParkingLot) < (calculateTheVacancyRate(comparedParkingLot))) {
                biggestVacancyRateParkingLotNumber = parkingLotNumber;
            }
        }
        return biggestVacancyRateParkingLotNumber;
    }

    private double calculateTheVacancyRate(ParkingLot biggestParkingLot) {
        return (double) (biggestParkingLot.getParkingLotRemainCount()) / (double) biggestParkingLot.getMaxParkingCount();
    }
}
