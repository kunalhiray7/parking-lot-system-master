package com.pls.commands

import com.pls.domain.Car
import com.pls.domain.ParkingLots
import spock.lang.Specification

import static com.pls.constants.Constants.LEAVE_TEMPLATE
import static java.lang.String.format

class LeaveParkingLotCommandSpec extends Specification {

    ParkingLots parkingLots
    ParkingLotSystemCommand command

    def setup() {
        parkingLots = new ParkingLots()
        parkingLots.create(6)
    }

    def "should execute the command to driveway the given car"() {
        given:
        def leaveSlot = 2
        def car1 = new Car("KA-01-BB-0001", "Black")
        def car2 = new Car("KA-01-BB-0002", "White")
        def car3 = new Car("KA-01-BB-0003", "Red")
        parkingLots.park(car1)
        parkingLots.park(car2)
        parkingLots.park(car3)
        def commandStr = "leave " + leaveSlot
        command = new LeaveParkingLotCommand(parkingLots, commandStr)

        when:
        def result = command.execute()

        then:
        result == format(LEAVE_TEMPLATE, leaveSlot)
    }

}
