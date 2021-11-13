package ru.netology.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RadioTest {
    Radio radioman = new Radio();

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,5,6",
            "equivalencePartitionOutLimitsBelow,-20,1",
            "equivalencePartitionOutLimitsAbove,20,1",
            "onMinLimit,0,1",
            "onMaxLimit,9,0",
            "boundaryOutBelowMinLimit,-1,1",
            "boundaryOutAboveMaxLimit,10,1",
            "boundaryInNearMinLimit,1,2",
            "boundaryInNearMaxLimit,8,9"})
    void shouldShiftNextStation(String testcase, int currentStation, int expected) {
        radioman.setCurrentStation(currentStation);
        radioman.shiftNextStation();
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,5,4",
            "equivalencePartitionOutLimitsBelow,-20,9",
            "equivalencePartitionOutLimitsAbove,20,9",
            "onMinLimit,0,9",
            "onMaxLimit,9,8",
            "boundaryOutBelowMinLimit,-1,9",
            "boundaryOutAboveMaxLimit,10,9",
            "boundaryInNearMinLimit,1,0",
            "boundaryInNearMaxLimit,8,7"})
    void shouldShiftPrevStation(String testcase, int currentStation, int expected) {
        radioman.setCurrentStation(currentStation);
        radioman.shiftPrevStation();
        int actual = radioman.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,50,51",
            "equivalencePartitionOutLimitsBelow,-50,1",
            "equivalencePartitionOutLimitsAbove,150,1",
            "onMinLimit,0,1",
            "onMaxLimit,100,100",
            "boundaryOutBelowMinLimit,-1,1",
            "boundaryOutAboveMaxLimit,101,1",
            "boundaryInNearMinLimit,1,2",
            "boundaryInNearMaxLimit,99,100"})
    void shouldIncreaseVolume(String testcase, int currentVolume, int expected) {
        radioman.setCurrentVolume(currentVolume);
        radioman.increaseVolume();
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,50,49",
            "equivalencePartitionOutLimitsBelow,-50,0",
            "equivalencePartitionOutLimitsAbove,150,0",
            "onMinLimit,0,0",
            "onMaxLimit,100,99",
            "boundaryOutBelowMinLimit,-1,0",
            "boundaryOutAboveMaxLimit,101,0",
            "boundaryInNearMinLimit,1,0",
            "boundaryInNearMaxLimit,99,98"})
    void shouldDecreaseVolume(String testcase, int currentVolume, int expected) {
        radioman.setCurrentVolume(currentVolume);
        radioman.decreaseVolume();
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,50,50",
            "equivalencePartitionOutLimits,-50,10",
            "onMinLimit,1,1",
            "onMaxLimit,2147483647,2147483647",
            "boundaryOutBelowMinLimit,0,10",
            "boundaryInNearMinLimit,2,2",
            "boundaryInNearMaxLimit,2147483646,2147483646"})
    void shouldInitNumberOfStations(String testcase, int numberOfStations, int expected) {
        radioman.setNumberOfStations(numberOfStations);
        int actual = radioman.getNumberOfStations();
        assertEquals(expected, actual);
    }

    Radio radioman1 = new Radio(50);

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,25,26",
            "equivalencePartitionOutLimitsBelow,-20,1",
            "equivalencePartitionOutLimitsAbove,70,1",
            "onMinLimit,0,1",
            "onMaxLimit,49,0",
            "boundaryOutBelowMinLimit,-1,1",
            "boundaryOutAboveMaxLimit,50,1",
            "boundaryInNearMinLimit,1,2",
            "boundaryInNearMaxLimit,48,49"})
    void shouldShiftNextStationIfNumberOfStationsAboveZero(String testcase, int currentStation, int expected) {
        radioman1.setCurrentStation(currentStation);
        radioman1.shiftNextStation();
        int actual = radioman1.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,25,24",
            "equivalencePartitionOutLimitsBelow,-20,49",
            "equivalencePartitionOutLimitsAbove,70,49",
            "onMinLimit,0,49",
            "onMaxLimit,49,48",
            "boundaryOutBelowMinLimit,-1,49",
            "boundaryOutAboveMaxLimit,50,49",
            "boundaryInNearMinLimit,1,0",
            "boundaryInNearMaxLimit,48,47"})
    void shouldShiftPrevStationIfNumberOfStationsAboveZero(String testcase, int currentStation, int expected) {
        radioman1.setCurrentStation(currentStation);
        radioman1.shiftPrevStation();
        int actual = radioman1.getCurrentStation();
        assertEquals(expected, actual);
    }

    // интересный случай, если numberOfStations = 1 - одна станция #0 - она же минимальная и максимальная одновременно
    Radio radioman2 = new Radio(1);

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,0,0",
            "equivalencePartitionOutLimitsBelow,-20,0",
            "equivalencePartitionOutLimitsAbove,20,0",
            "onMinLimit,0,0",
            "onMaxLimit,0,0",
            "boundaryOutBelowMinLimit,-1,0",
            "boundaryOutAboveMaxLimit,1,0"})
    void shouldShiftNextStationIfNumberOfStationsEqualsOne(String testcase, int currentStation, int expected) {
        radioman2.setCurrentStation(currentStation);
        radioman2.shiftNextStation();
        int actual = radioman2.getCurrentStation();
        assertEquals(expected, actual);
    }
    
    // Экзотический случай radioman3, если Радио управляется не человеком, а, например, автоматической системой,
    // и в ней произошёл сбой, и посылается invalid сигнал с (numberOfStations <= 0).
    // При таких входных данных Радио автоматически должно перейти в дефолтный диапазон с (numberOfStations = 10).

    Radio radioman3 = new Radio(0);

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,5,6",
            "equivalencePartitionOutLimitsBelow,-20,1",
            "equivalencePartitionOutLimitsAbove,20,1",
            "onMinLimit,0,1",
            "onMaxLimit,9,0",
            "boundaryOutBelowMinLimit,-1,1",
            "boundaryOutAboveMaxLimit,10,1",
            "boundaryInNearMinLimit,1,2",
            "boundaryInNearMaxLimit,8,9"})
    void shouldShiftNextStationIfNumberOfStationsInvalid(String testcase, int currentStation, int expected) {
        radioman3.setCurrentStation(currentStation);
        radioman3.shiftNextStation();
        int actual = radioman3.getCurrentStation();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,5,4",
            "equivalencePartitionOutLimitsBelow,-20,9",
            "equivalencePartitionOutLimitsAbove,20,9",
            "onMinLimit,0,9",
            "onMaxLimit,9,8",
            "boundaryOutBelowMinLimit,-1,9",
            "boundaryOutAboveMaxLimit,10,9",
            "boundaryInNearMinLimit,1,0",
            "boundaryInNearMaxLimit,8,7"})
    void shouldShiftPrevStationIfNumberOfStationsInvalid(String testcase, int currentStation, int expected) {
        radioman3.setCurrentStation(currentStation);
        radioman3.shiftPrevStation();
        int actual = radioman3.getCurrentStation();
        assertEquals(expected, actual);
    }
}
