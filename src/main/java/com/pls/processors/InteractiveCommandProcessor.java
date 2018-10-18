package com.pls.processors;

import com.pls.domain.ParkingLots;

import java.util.Scanner;

import static com.pls.ParkingLotSystemCommandFactory.getCommand;

public class InteractiveCommandProcessor {

    public static void processCommands() {
        try (Scanner scanner = new Scanner(System.in)) {
            ParkingLots parkingLots = new ParkingLots();
            while (scanner.hasNext()) {
                String commandStr = scanner.nextLine();
                System.out.println(getCommand(commandStr, parkingLots).execute());
            }
        }
    }

}
