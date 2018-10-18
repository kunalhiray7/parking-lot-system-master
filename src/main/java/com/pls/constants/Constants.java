package com.pls.constants;

public final class Constants {
    public static final String CREATED_TEMPLATE = "Created a parking lot with %s slots";
    public static final String PARKED_TEMPLATE = "Allocated slot number: %s";
    public static final String PARKING_LOT_NOT_CREATED = "Parking lot is not created yet!!";
    public static final String LEAVE_TEMPLATE = "Slot number %s is free";
    public static final String NO_CAR_TEMPLATE = "There is no car at %s slot";
    public static final String LIMIT_EXCEEDS = "Invalid command - cannot leave the car at slot greater than parking lot capacity";
    public static final String LINE_SEPARATOR = System.lineSeparator();
    public static final String TAB = "\t";
    public static final String NOT_FOUND = "Not found";
    public static final String PARKING_FULL = "Sorry, parking lot is full";

    // Commands
    public static final String CREATE_COMMAND = "create_parking_lot";
    public static final String PARK_COMMAND = "park";
    public static final String LEAVE_COMMAND = "leave";
    public static final String STATUS_COMMAND = "status";
    public static final String GET_REGISTRATION_NUMBERS_COMMAND = "registration_numbers_for_cars_with_colour";
    public static final String GET_SLOT_NUMBERS_FOR_COLOR_COMMAND = "slot_numbers_for_cars_with_colour";
    public static final String GET_SLOT_NUMBER_FOR_REGISTRATION_NO_COMMAND = "slot_number_for_registration_number";
}
