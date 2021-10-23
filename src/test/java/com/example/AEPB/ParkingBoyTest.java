package com.example.AEPB;

import com.example.parking.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
 * given 1号停车场的只有一个空车位，停车小弟。
 * when 停车
 * then 停车小弟在1号停车场的停车成功
 *
 * given 拿车票取车停车小弟。
 * when 取车
 * then 停车小弟在1号停车场的取车成功
 *
 * given 10个空停车场，自己停车。
 * when 停车
 * then 停车成功返回车票
 *
 * given 没有空位的一号停车场自己停车。
 * when 停车
 * then 停车失败
 *
 * given 自己拿车票取车。
 * when 停车
 * then 取车成功
 */
public class ParkingBoyTest {
    private ParkingLot setupNumParkingLot(int num) {
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 1; i <= num; i++) {
            Car car = new Car();
            parkingLot.parkingCarAndGetTicket(car);
        }
        return parkingLot;
    }

    @Test
    void should_return_ticket_successfully_when_parkingBoy_parking_given_parkingLot_one_which_has_49_car_and_one_parking_car() {
        //given
        ParkingLot parkingLot = setupNumParkingLot(49);
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        parkingLotGroup.getParkingLotList().get(0).setParkingLotMap(parkingLot.getParkingLotMap());
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.parkingBoyParkingCarAndGetTicket(parkingLotGroup, car);
        //then
        assertNotNull(ticket);
    }

    @Test
    void should_return_car_successfully_when_parkingBoy_take_the_car_given_one_car_parked_in_parkingLot_and_one_matched_ticket() {
        //given
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        ParkingBoy parkingBoy = new ParkingBoy();
        Car car = new Car();
        //when
        Ticket ticket = parkingBoy.parkingBoyParkingCarAndGetTicket(parkingLotGroup, car);
        //then
        assertEquals(car, parkingBoy.getCar(parkingLotGroup, ticket));
    }

    @Test
    void should_return_ticket_successfully_when_parking_given_ten_empty_parkingLots_and_one_parking_car() {
        //given
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        //when
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicket(2, car);
        //then
        assertNotNull(ticket);
    }
    @Test
    void should_return_car_successfully_when_take_the_car_given_one_car_parked_in_parkingLot_and_one_matched_ticket() {
        //given
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        Car car = new Car();
        //when
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicket(2, car);
        //then
        assertEquals(car, parkingLotGroup.getCar(ticket));
    }
    @Test
    void should_return_ticket_successfully_when_parking_given_not_empty_parkingLots_and_one_parking_car() {
        //given
        ParkingLot parkingLot = setupNumParkingLot(50);
        ParkingLotGroup parkingLotGroup = new ParkingLotGroup();
        parkingLotGroup.getParkingLotList().get(0).setParkingLotMap(parkingLot.getParkingLotMap());
        Car car = new Car();
        //when
        Ticket ticket = parkingLotGroup.parkingCarAndGetTicket(0, car);
        //then
        assertNull(ticket);
    }


}
