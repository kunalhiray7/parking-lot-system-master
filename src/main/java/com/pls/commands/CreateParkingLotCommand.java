package com.pls.commands;

import com.pls.domain.ParkingLots;

public class CreateParkingLotCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;
    private String commandStr;

    public CreateParkingLotCommand(ParkingLots parkingLots, String commandStr) {
        this.parkingLots = parkingLots;
        this.commandStr = commandStr;
    }

    @Override
    public String execute() {
        int size = Integer.parseInt(commandStr.split(" ")[1]);
        return parkingLots.create(size);
    }
}
