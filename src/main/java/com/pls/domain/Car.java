package com.pls.domain;

public class Car {
    private String registrationNumber;
    private String color;

    public Car(String registrationNumber, String color) {
        this.registrationNumber = registrationNumber;
        this.color = color;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getColor() {
        return color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;

        Car car = (Car) o;

        return getRegistrationNumber() != null ? getRegistrationNumber().equals(car.getRegistrationNumber()) : car.getRegistrationNumber() == null && (getColor() != null ? getColor().equals(car.getColor()) : car.getColor() == null);

    }

    @Override
    public int hashCode() {
        int result = getRegistrationNumber() != null ? getRegistrationNumber().hashCode() : 0;
        result = 31 * result + (getColor() != null ? getColor().hashCode() : 0);
        return result;
    }
}
