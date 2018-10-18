package com.pls.commands;

import com.pls.domain.ParkingLots;

public class GetSlotForRegistrationNumberCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;
    private String commandStr;

    public GetSlotForRegistrationNumberCommand(ParkingLots parkingLots, String commandStr) {
        this.parkingLots = parkingLots;
        this.commandStr = commandStr;
    }

    @Override
    public String execute() {
        String registrationNumber = commandStr.split(" ")[1];
        return parkingLots.getSlotForRegistrationNumber(registrationNumber);
    }
}
