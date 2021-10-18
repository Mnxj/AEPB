package com.example.AEPB;


import com.example.parking.AEPB.Car;
import com.example.parking.AEPB.ParkingLot;
import com.example.parking.AEPB.Ticket;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;

/*
 1、
 * given 空的停车场和一辆想要存的车
 * when 存车
 * then 存车成功给予存车票
 2、
 * * given 存有50辆车的停车场和一辆想存的车
 * when 存车
 * then 存车失败没有存车票
 3、
 * given 存有49辆车的停车场和一辆想要存的车
 * when 存车
 * then 存车成功并拿到存车票
 4、
 * given 空的停车场和我没有车
 * when 存车
 * then 存车失败抛出异常
 5、
 * given 有车的停车场和一张存车票
 * when 取车
 * then 取车成功并开出车
 6、
 * given 空的停车场和一张无效存车票
 * when 取车
 * then 取车失败抛出异常
 7、
 * given 有车的停车场和一张无效存车票
 * when 取车
 * then 取车失败抛出异常
 8、
 * given 有辆车的停车场和我没票
 * when 取车
 * then 取车失败抛出异常
 *
 * */
public class ParkingLotTest {
    @Test
    void should_return_ticket_successfully_when_parking_car_given_empty_parkingLot_and_one_parking_car() {
        ParkingLot parkingLot = new ParkingLot();
        Car car = new Car(String.valueOf(parkingLot.hashCode()));
        Ticket ticket = parkingLot.parkingCarAndGetTicket(car);
        assertEquals(1, parkingLot.getTicketCount());
        assertEquals(49, parkingLot.getParkingLotSpace());
        assertEquals(10,ticket.getTicketNumber().length());
    }
    @Test
    void should_return_ticket_successfully_when_parking_car_given_parkingLot_which_has_49_car_and_one_parking_car() {
        ParkingLot parkingLot = setupNumParkingLot(49);
        Car car = new Car(String.valueOf(parkingLot.hashCode()));
        parkingLot.parkingCarAndGetTicket(car);
        assertEquals(50, parkingLot.getTicketCount());
        assertEquals(0, parkingLot.getParkingLotSpace());
    }

    private ParkingLot setupNumParkingLot(int num) {
        ParkingLot parkingLot = new ParkingLot();
        for (int i = 1; i <= num; i++) {
            Car car = new Car(String.valueOf(parkingLot.hashCode()));
            parkingLot.parkingCarAndGetTicket(car);
        }
        return parkingLot;
    }

}
