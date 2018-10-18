package com.pls.domain;

public class ParkingLot {
    private int lotNumber;
    private Car car;

    ParkingLot(int lotNumber, Car car) {
        this.lotNumber = lotNumber;
        this.car = car;
    }

    public int getLotNumber() {
        return lotNumber;
    }

    public Car getCar() {
        return car;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingLot)) return false;

        ParkingLot lot = (ParkingLot) o;

        return getLotNumber() == lot.getLotNumber() && (getCar() != null ? getCar().equals(lot.getCar()) : lot.getCar() == null);

    }

    @Override
    public int hashCode() {
        int result = getLotNumber();
        result = 31 * result + (getCar() != null ? getCar().hashCode() : 0);
        return result;
    }
}
