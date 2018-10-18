package com.pls.commands;

import com.pls.domain.Car;
import com.pls.domain.ParkingLots;

public class ParkCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;
    private String commandStr;

    public ParkCommand(ParkingLots parkingLots, String commandStr) {
        this.parkingLots = parkingLots;
        this.commandStr = commandStr;
    }

    @Override
    public String execute() {
        String[] tokens = commandStr.split(" ");
        String registrationNumber = tokens[1];
        String color = tokens[2];
        Car car = new Car(registrationNumber, color);
        return parkingLots.park(car);
    }
}
