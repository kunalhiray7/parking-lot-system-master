package com.pls.domain;

import java.util.ArrayList;
import java.util.List;

import static com.pls.constants.Constants.*;
import static java.lang.String.format;

public class ParkingLots {
    private int size;
    private ParkingLot[] lots;


    public String create(int size) {
        this.size = 0;
        lots = new ParkingLot[size];
        return format(CREATED_TEMPLATE, size);
    }

    public int allottedSize() {
        return size;
    }

    public int capacity() {
        return lots.length;
    }

    public String park(Car car) {
        if (lots != null) {
            for (int i = 0; i < lots.length; i++) {
                if (lots[i] == null) {
                    lots[i] = new ParkingLot(i + 1, car);
                    size++;
                    return format(PARKED_TEMPLATE, i + 1);
                }
            }
            return PARKING_FULL;
        }
        return PARKING_LOT_NOT_CREATED;
    }

    public String leave(int leaveSlot) {
        if (lots != null) {
            if (leaveSlot <= lots.length) {
                if (lots[leaveSlot - 1] != null) {
                    lots[leaveSlot - 1] = null;
                    size--;
                    return format(LEAVE_TEMPLATE, leaveSlot);
                } else {
                    return format(NO_CAR_TEMPLATE, leaveSlot);
                }
            } else {
                return LIMIT_EXCEEDS;
            }
        }
        return PARKING_LOT_NOT_CREATED;
    }

    public ParkingLot[] getLots() {
        return lots;
    }

    public List<ParkingLot> getLotsWithColor(String color) {
        List<ParkingLot> lotsWithGivenColor = new ArrayList<>();
        for (ParkingLot lot : lots) {
            if (lot != null) {
                if (lot.getCar().getColor().equals(color)) {
                    lotsWithGivenColor.add(lot);
                }
            }
        }
        return lotsWithGivenColor;
    }

    public String getSlotForRegistrationNumber(String registrationNumber) {
        for(ParkingLot lot : lots) {
            if(lot != null && lot.getCar().getRegistrationNumber().equals(registrationNumber)) {
                return "" + lot.getLotNumber();
            }
        }
        return NOT_FOUND;
    }
}
