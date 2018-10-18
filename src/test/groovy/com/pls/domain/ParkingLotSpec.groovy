package com.pls.domain

import spock.lang.Specification

class ParkingLotSpec extends Specification {

    def "should create the parking lot for gien car"() {
        given:
        def car = new Car("KA-01-HH-1234", "White")

        when:
        def parkingLot = new ParkingLot(1, car)

        then:
        parkingLot.getLotNumber() == 1
        parkingLot.getCar() == car
    }

}
