package com.example.parking;

import com.example.parking.entity.Car;
import com.example.parking.entity.Ticket;

public interface Parking {
    Ticket parkingCarAndGetTicket(Car car);
}
