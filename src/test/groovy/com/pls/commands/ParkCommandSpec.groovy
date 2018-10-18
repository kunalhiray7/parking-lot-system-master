package com.pls.commands

import com.pls.domain.ParkingLots
import spock.lang.Specification

class ParkCommandSpec extends Specification {

    ParkingLotSystemCommand command
    ParkingLots parkingLots

    def setup() {
        parkingLots = new ParkingLots()
        parkingLots.create(6)
    }

    def "should invoke a command to park the car"() {
        given:
        def commandStr = "park KA-01-HH-1234 White"
        command = new ParkCommand(parkingLots, commandStr)

        when:
        def result = command.execute()

        then:
        result == "Allocated slot number: 1"
    }
}
