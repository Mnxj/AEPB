package com.example.AEPB;

/*
 * given 1号停车场停有1辆车，其他停车场为空，smart Parking boy，一辆车
 * when 停车
 * then 停车成功并获得车票，停在了2号停车位
 *
 * given 1号和2号停车场停有1辆车，其他停车场为空，smart Parking boy，一辆车
 * when 停车
 * then 停车成功并获得车票，停在了2号停车位
 *
 * given 都是空停车场，smart boy，一辆车
 * when 停车
 * then  停车成功并获得车票，停在了1号停车位
 *
 *
 * given 一张有效车票，smart boy
 * when 取车
 * then  取车成功
 *
 *
*/

import com.example.parking.*;
import com.example.parking.entity.Car;
import com.example.parking.entity.Ticket;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {
    private Map<String, ParkingLot> creatParkingLots() {
        Map<String, ParkingLot> parkingLotMap = new HashMap<>();
        IntStream.rangeClosed(1, 10).forEach(parkingLotNumber -> {
            ParkingLot parkingLot = new ParkingLot();
            parkingLotMap.put(String.valueOf(parkingLotNumber), parkingLot);
        });
        return parkingLotMap;
    }
    @Test
    void should_return_ticket_successfully_when_smartParkingBoy_parking_given_parkingLot_one_which_has_49_and_one_parking_car(){
        Map<String, ParkingLot> parkingLotMap = creatParkingLots();
        parkingLotMap.get("1").parkingCarAndGetTicket(new Car());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotMap);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.parkingCarAndGetTicket(car);
        assertNotNull(ticket);
        assertNotNull(parkingLotMap.get("2"));
    }
    @Test
    void should_return_ticket_successfully_when_smartParkingBoy_parking_given_parkingLot_one_and_two_which_has_49_and_one_parking_car(){
        Map<String, ParkingLot> parkingLotMap = creatParkingLots();
        parkingLotMap.get("1").parkingCarAndGetTicket(new Car());
        parkingLotMap.get("2").parkingCarAndGetTicket(new Car());
        parkingLotMap.get("2").parkingCarAndGetTicket(new Car());
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotMap);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.parkingCarAndGetTicket(car);
        assertNotNull(ticket);
        assertNotNull(parkingLotMap.get("3"));
    }

    @Test
    void should_return_ticket_successfully_when_smartParkingBoy_parking_given_empty_parkingLot_and_one_parking_car(){
        Map<String, ParkingLot> parkingLotMap = creatParkingLots();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotMap);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.parkingCarAndGetTicket(car);
        assertNotNull(ticket);
        assertNotNull(parkingLotMap.get("1"));
    }
    @Test
    void should_return_car_successfully_when_smartParkingBoy_take_the_car_given_one_car_parked_in_parkingLot_and_one_matched_ticket(){
        Map<String, ParkingLot> parkingLotMap = creatParkingLots();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy(parkingLotMap);
        Car car = new Car();
        Ticket ticket = smartParkingBoy.parkingCarAndGetTicket(car);
        assertEquals(car, parkingLotMap.get("1").getCar(ticket));
    }

}
