package com.example.AEPB;

import com.example.excepition.InvalidParkingException;
import com.example.parking.ParkingLot;
import com.example.parking.ParkingRobot;
import com.example.parking.entity.Car;
import com.example.parking.entity.Ticket;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ParkingRobotTest {
    /*
     * 1.
     * given 两个停车场，1号停车场20个停车位停有1辆车，2号停车场40个停车位停有2两辆车，ParkingRobot，一辆车
     * when 停车
     * then 停车成功并获得车票，停在了2号停车位
     * */
    @Test
    void should_park_car_at_no2_parking_lot_and_get_ticket_successfully_when_one_car_parked_at_no1_parking_lot_which_has_20_parking_space_and_two_cars_parked_at_no2_parking_lot_which_has_40_parking_space_and_parking_robot_and_one_car() {
        ParkingLot smallerVacancyRateParkingLot = new ParkingLot(20);
        ParkingLot biggestVacancyRateParkingLot = new ParkingLot(40);
        smallerVacancyRateParkingLot.parkingCarAndGetTicket(new Car());
        biggestVacancyRateParkingLot.parkingCarAndGetTicket(new Car());
        biggestVacancyRateParkingLot.parkingCarAndGetTicket(new Car());
        Map<String, ParkingLot> parkingLotMap = new HashMap<>();
        parkingLotMap.put("1", smallerVacancyRateParkingLot);
        parkingLotMap.put("2", biggestVacancyRateParkingLot);
        ParkingRobot parkingRobot = new ParkingRobot(parkingLotMap);
        Car newCar = new Car();
        Ticket ticket = parkingRobot.parkingCarAndGetTicket(newCar);
        assertNotNull(ticket);
        assertNotNull(parkingLotMap.get("2"));
    }
    /*
     * 2.
     * given 两个个停车场，1号停车场1个停车位没有停车，2号停车场2个停车位没有停车，ParkingRobot，一辆车
     * when 停车
     * then 停车成功并获得车票，停在了1号停车位
     * */
    @Test
    void should_park_car_at_no1_parking_lot_and_get_ticket_successfully_when_parking_car_given_no1_parking_lot_has_same_vacancy_rate_with_no2_parking_lot_and_parking_robot_and_one_car() {
        ParkingLot firstBiggestVacancyRateParkingLot = new ParkingLot(1);
        ParkingLot secondBiggestVacancyRateParkingLot = new ParkingLot(2);
        Map<String, ParkingLot> parkingLotMap = new HashMap<>();
        parkingLotMap.put("1", firstBiggestVacancyRateParkingLot);
        parkingLotMap.put("2", secondBiggestVacancyRateParkingLot);
        ParkingRobot parkingRobot = new ParkingRobot(parkingLotMap);
        Car newCar = new Car();
        Ticket ticket = parkingRobot.parkingCarAndGetTicket(newCar);
        assertNotNull(ticket);
        assertNotNull(parkingLotMap.get("1"));
    }

    /*
     * 3.
     * given 两个停车场，1号停车场4个停车位停满，2号停车场5个停车位停满，ParkingRobot，一辆车
     * when 停车
     * then 停车失败并抛异常
     * */
    @Test
    void should_park_car_fail_and_throw_exception_when_parking_car_given_4_cars_parked_at_no1_parking_lot_and_5_cars_parked_at_no2_parking_lot_and_parking_robot_and_one_car() {
        ParkingLot firstBiggestVacancyRateParkingLot = new ParkingLot(4);
        ParkingLot secondBiggestVacancyRateParkingLot = new ParkingLot(5);
        for (int i = 0; i < 4; i++) {
            firstBiggestVacancyRateParkingLot.parkingCarAndGetTicket(new Car());
        }
        for (int i = 0; i < 5; i++) {
            secondBiggestVacancyRateParkingLot.parkingCarAndGetTicket(new Car());
        }
        Map<String, ParkingLot> parkingLotMap = new HashMap<>();
        parkingLotMap.put("1", firstBiggestVacancyRateParkingLot);
        parkingLotMap.put("2", secondBiggestVacancyRateParkingLot);
        ParkingRobot parkingRobot = new ParkingRobot(parkingLotMap);
        Car newCar = new Car();
        assertThrows(InvalidParkingException.class, () -> parkingRobot.parkingCarAndGetTicket(newCar));
    }
    /*
     * 4.
     * given 一个停车场，停车场5个停车位没有车，ParkingRobot，一辆车
     * when 停车
     * then 停车成功并获得车票
     * */
    @Test
    void should_park_car_and_get_ticket_successfully_when_parking_car_given_one_parking_lot_has_5_empty_parking_space() {
        ParkingLot parkingLot = new ParkingLot(10);
        Map<String, ParkingLot> parkingLotMap = new HashMap<>();
        parkingLotMap.put("1", parkingLot);
        ParkingRobot parkingRobot = new ParkingRobot(parkingLotMap);
        Car car = new Car();
        Ticket ticket = parkingRobot.parkingCarAndGetTicket(car);
        assertEquals(car, parkingLotMap.get("1").getCar(ticket));
    }
}
