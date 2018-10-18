package com.pls.commands;

import com.pls.domain.ParkingLot;
import com.pls.domain.ParkingLots;

import java.util.List;

import static com.pls.constants.Constants.NOT_FOUND;

public class GetRegistrationNumbersCommand implements ParkingLotSystemCommand {

    private ParkingLots parkingLots;
    private String commandStr;

    public GetRegistrationNumbersCommand(ParkingLots parkingLots, String commandStr) {
        this.parkingLots = parkingLots;
        this.commandStr = commandStr;
    }

    @Override
    public String execute() {
        String color = commandStr.split(" ")[1];

        List<ParkingLot> lotsWithColor = parkingLots.getLotsWithColor(color);
        StringBuilder sb = new StringBuilder();
        for(ParkingLot lot : lotsWithColor) {
            sb.append(lot.getCar().getRegistrationNumber()).append(", ");
        }

        String result = sb.toString();

        if(result.contains(",")) {
            result = result.substring(0, result.lastIndexOf(","));
        }

        return result.isEmpty() ? NOT_FOUND : result;
    }
}
