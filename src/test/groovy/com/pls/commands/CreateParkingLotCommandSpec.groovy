package com.pls.commands

import com.pls.domain.ParkingLots
import spock.lang.Specification

class CreateParkingLotCommandSpec extends Specification {

    ParkingLots parkingLots
    ParkingLotSystemCommand command

    def setup() {
        parkingLots = new ParkingLots()
        String commandStr = "create_parking_lot 6"
        command = new CreateParkingLotCommand(parkingLots, commandStr)
    }

    def "should invoke the command to create the parking lot"() {

        when:
        def result = command.execute()

        then:
        result == "Created a parking lot with 6 slots"
    }

}
