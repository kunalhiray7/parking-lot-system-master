package com.pls.processors;

import com.pls.domain.ParkingLots;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static com.pls.ParkingLotSystemCommandFactory.getCommand;
import static com.pls.constants.Constants.LINE_SEPARATOR;

public class FileProcessor {

    public static void processFile(String filePath) {
        try (Scanner scanner = new Scanner(new File(filePath))) {
            ParkingLots parkingLots = new ParkingLots();
            StringBuilder sb = new StringBuilder();
            while (scanner.hasNext()) {
                String commandStr = scanner.nextLine();
                sb.append(getCommand(commandStr, parkingLots).execute()).append(LINE_SEPARATOR);
            }
            System.out.println(sb.toString());
        } catch (FileNotFoundException e) {
            System.out.println(String.format("File with name %s does not exist. Exiting..", filePath));
            System.exit(0);
        }
    }
}
