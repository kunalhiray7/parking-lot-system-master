package com.pls.commands

import com.pls.domain.Car
import com.pls.domain.ParkingLots
import spock.lang.Specification

class GetSlotForRegistrationNumberCommandSpec extends Specification {

    ParkingLots parkingLots
    ParkingLotSystemCommand command

    def setup() {
        parkingLots = new ParkingLots()
        parkingLots.create(6)
    }

    def "should execute the command to get the slot number for given registration number car"() {
        given:
        def car1 = new Car("KA-01-BB-0001", "Black")
        def car2 = new Car("KA-01-BB-0002", "White")
        def car3 = new Car("KA-01-BB-0003", "White")
        parkingLots.park(car1)
        parkingLots.park(car2)
        parkingLots.park(car3)
        def commandStr = "slot_number_for_registration_number KA-01-BB-0001"
        command = new GetSlotForRegistrationNumberCommand(parkingLots, commandStr)

        when:
        def result = command.execute()

        then:
        result == "1"
    }

}
