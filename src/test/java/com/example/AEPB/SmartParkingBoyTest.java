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
 * given 都是满停车场，smart boy，一辆车
 * when 停车
 * then  停车失败并抛异常
 *
 * given 一张有效车票，smart boy
 * when 取车
 * then  取车成功
 *
 * given 一张无效车票，smart boy
 * when 取车
 * then  取车失败
 *
*/

import com.example.parking.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class SmartParkingBoyTest {
    private ParkingLot setupNumParkingLot(int num) {
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 1; i <= num; i++) {
            Car car = new Car();
            parkingLot.parkingCarAndGetTicket(car);
        }
        return parkingLot;
    }
    @Test
    void should_return_ticket_successfully_when_smartParkingBoy_parking_given_parkingLot_one_which_has_49_and_empty_parkingLot_Two_and_one_parking_car(){
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        ParkingLotGroup parkingLotGroup=new ParkingLotGroup();
        ParkingLot parkingLot = setupNumParkingLot(49);
        parkingLotGroup.getParkingLotList().get(0).setParkingLotMap(parkingLot.getParkingLotMap());
        Car car= new Car();
        Ticket ticket = smartParkingBoy.smartParkingBoyParkingCarAndGetTicket(parkingLotGroup, car);
        assertNotNull(ticket);
        assertEquals(1,parkingLotGroup.getParkingLotList().get(1).getParkingLotMap().size());
    }
    @Test
    void should_return_ticket_successfully_when_smartParkingBoy_parking_given_parkingLot_one_and_two_which_has_49_and_empty_parkingLot_Two_and_one_parking_car(){
        SmartParkingBoy smartParkingBoy=new SmartParkingBoy();
        ParkingLotGroup parkingLotGroup=new ParkingLotGroup();
        ParkingLot parkingLot = setupNumParkingLot(49);
        ParkingLot parkingLot1 = setupNumParkingLot(49);
        parkingLotGroup.getParkingLotList().get(0).setParkingLotMap(parkingLot.getParkingLotMap());
        parkingLotGroup.getParkingLotList().get(1).setParkingLotMap(parkingLot1.getParkingLotMap());
        Car car= new Car();
        Ticket ticket = smartParkingBoy.smartParkingBoyParkingCarAndGetTicket(parkingLotGroup, car);
        assertNotNull(ticket);
        assertEquals(1,parkingLotGroup.getParkingLotList().get(2).getParkingLotMap().size());
    }

}
