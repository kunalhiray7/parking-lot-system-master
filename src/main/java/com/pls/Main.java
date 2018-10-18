package com.pls;

import static com.pls.processors.FileProcessor.processFile;
import static com.pls.processors.InteractiveCommandProcessor.processCommands;

public class Main {

    public static void main(String[] args) {

        if(args.length == 1) {
            processFile(args[0]);
        } else if (args.length == 0) {
            processCommands();
        } else {
            System.out.println("Wrong usage, refer README. Exiting..");
            System.exit(0);
        }

    }
}
