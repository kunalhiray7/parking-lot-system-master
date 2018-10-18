package com.pls.commands

import com.pls.domain.Car
import com.pls.domain.ParkingLots
import spock.lang.Specification

class StatusCommandSpec extends Specification {

    ParkingLots parkingLots
    ParkingLotSystemCommand command

    def setup() {
        parkingLots = new ParkingLots()
        parkingLots.create(6)
    }

    def "should execute the command to fetch the status"() {
        given:
        parkingLots.create(4)
        def car1 = new Car("KA-01-BB-0001", "Black")
        def car2 = new Car("KA-01-BB-0002", "White")
        def car3 = new Car("KA-01-BB-0003", "Red")
        parkingLots.park(car1)
        parkingLots.park(car2)
        parkingLots.park(car3)
        def commandStr = "status"
        command = new StatusCommand(parkingLots, commandStr)

        when:
        def result = command.execute()

        then:
        result == """Slot No.\tRegistration No\tColour\n1\tKA-01-BB-0001\tBlack\n2\tKA-01-BB-0002\tWhite\n3\tKA-01-BB-0003\tRed\n"""
    }

}
