package com.pls.domain

import spock.lang.Specification

class CarSpec extends Specification {

    def "should create a car with specified details"() {
        given:
        def registrationNumber = "MH-12-DD-2233"
        def color = "Red"

        when:
        def car = new Car(registrationNumber, color)

        then:
        car.getColor() == color
        car.getRegistrationNumber() == registrationNumber
    }

}
