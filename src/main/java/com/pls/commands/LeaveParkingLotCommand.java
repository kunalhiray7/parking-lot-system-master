package com.pls.commands;

import com.pls.domain.ParkingLots;

public class LeaveParkingLotCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;
    private String commandStr;

    public LeaveParkingLotCommand(ParkingLots parkingLots, String commandStr) {
        this.parkingLots = parkingLots;
        this.commandStr = commandStr;
    }

    @Override
    public String execute() {
        int leaveSlot = Integer.parseInt(commandStr.split(" ")[1]);
        return parkingLots.leave(leaveSlot);
    }
}
