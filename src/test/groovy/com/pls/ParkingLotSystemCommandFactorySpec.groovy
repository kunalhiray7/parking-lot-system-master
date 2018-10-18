package com.pls

import com.pls.commands.*
import com.pls.domain.ParkingLots
import spock.lang.Specification

import static com.pls.constants.Constants.*

class ParkingLotSystemCommandFactorySpec extends Specification {

    def "should return appropriate instance of command for given input command string"() {
        given:
        def parkingLots = new ParkingLots()

        when:
        def commandInstance = ParkingLotSystemCommandFactory.getCommand(commandStr, parkingLots)

        then:
        commandInstance.class == expectedInstance

        where:
        commandStr                                  | expectedInstance
        CREATE_COMMAND                              | CreateParkingLotCommand
        PARK_COMMAND                                | ParkCommand
        LEAVE_COMMAND                               | LeaveParkingLotCommand
        STATUS_COMMAND                              | StatusCommand
        GET_REGISTRATION_NUMBERS_COMMAND            | GetRegistrationNumbersCommand
        GET_SLOT_NUMBER_FOR_REGISTRATION_NO_COMMAND | GetSlotForRegistrationNumberCommand
        GET_SLOT_NUMBERS_FOR_COLOR_COMMAND          | GetSlotsForColorCommand
    }

    def "should throw IllegalStateException when commandStr did not match with any of the expected commands"() {
        given:
        def parkingLots = new ParkingLots()
        def commandStr = "ABCD"

        when:
        ParkingLotSystemCommandFactory.getCommand(commandStr, parkingLots)

        then:
        IllegalStateException e = thrown()
        e.message == "The command format is not correct."
    }

}
