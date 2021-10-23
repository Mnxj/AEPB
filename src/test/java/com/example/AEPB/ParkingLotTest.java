package com.example.AEPB;


import com.example.parking.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 1、
 * given 空的停车场和一辆想要存的车
 * when 存车
 * then 存车成功给予存车票
 2、
 * * given 存有49辆车的停车场和两辆想存的车
 * when 存车
 * then 存车失败没有存车票
 3、
 * * given 存有50辆车的停车场和一辆想存的车
 * when 存车
 * then 存车失败没有存车票
 4、
 * given 空的停车场和我没有车
 * when 存车
 * then 存车失败抛出异常
 5、
 * given 空的停车场和一张无效存车票
 * when 取车
 * then 取车失败抛出异常
 6、
 * given 有车的停车场和一张无效存车票
 * when 取车
 * then 取车失败抛出异常
 *



 given




 * */
public class ParkingLotTest {
    @Test
    void should_return_ticket_successfully_when_parking_car_given_empty_parkingLot_and_one_parking_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.parkingCarAndGetTicket(car);
        assertEquals(car, parkingLot.getCar(ticket));
    }
    @Test
    void should_return_null_ticket_when_parking_car_given_parkingLot_which_has_50_car_and_one_parking_car() {
        ParkingLot parkingLot = setupNumParkingLot(50);
        Car car = new Car();
        parkingLot.parkingCarAndGetTicket(car);
        assertNull(parkingLot.parkingCarAndGetTicket(car));
    }
    @Test
    void should_return_ticket_successfully_when_parking_car_given_parkingLot_which_has_49_car_and_one_parking_car() {
        ParkingLot parkingLot = setupNumParkingLot(49);
        Car car = new Car();
        Ticket ticket = parkingLot.parkingCarAndGetTicket(car);
        assertEquals(car, parkingLot.getCar(ticket));
    }

    @Test
    void should_return_car_successfully_when_take_the_car_given_one_car_parked_in_parkingLot_and_one_matched_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        Ticket ticket = parkingLot.parkingCarAndGetTicket(car);
        assertEquals(car, parkingLot.getCar(ticket));
    }

    @Test
    void should_throw_exception_when_parking_car_given_empty_parkingLot_and_no_parking_car() {
        ParkingLot parkingLot = new ParkingLot();
        assertThrows(InvalidParkingException.class, () -> parkingLot.parkingCarAndGetTicket(null));
    }

    @Test
    void should_throw_exception_when_take_the_car_given_parkingLot_has_car_and_no_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        assertThrows(InvalidGettingException.class, () -> parkingLot.getCar(null));
    }
    @Test
    void should_throw_exception_when_take_the_car_given_empty_parkingLot_and_one_invalid_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        assertThrows(InvalidGettingException.class, () -> parkingLot.getCar(new Ticket()));
    }
    @Test
    void should_throw_exception_when_take_the_car_given_parkingLot_and_one_notMatched_ticket() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car();
        parkingLot.parkingCarAndGetTicket(car);
        assertThrows(InvalidGettingException.class, () -> parkingLot.getCar(null));
    }

    private ParkingLot setupNumParkingLot(int num) {
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 1; i <= num; i++) {
            Car car = new Car();
            parkingLot.parkingCarAndGetTicket(car);
        }
        return parkingLot;
    }



}
