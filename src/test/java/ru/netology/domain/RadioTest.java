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
    @CsvSource(value = {"equivalencePartitionInLimits,5,6",
            "equivalencePartitionOutLimitsBelow,-20,1",
            "equivalencePartitionOutLimitsAbove,20,1",
            "onMinLimit,0,1",
            "onMaxLimit,10,10",
            "boundaryOutBelowMinLimit,-1,1",
            "boundaryOutAboveMaxLimit,11,1",
            "boundaryInNearMinLimit,1,2",
            "boundaryInNearMaxLimit,9,10"})
    void shouldIncreaseVolume(String testcase, int currentVolume, int expected) {
        radioman.setCurrentVolume(currentVolume);
        radioman.increaseVolume();
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @CsvSource(value = {"equivalencePartitionInLimits,5,4",
            "equivalencePartitionOutLimitsBelow,-20,0",
            "equivalencePartitionOutLimitsAbove,20,0",
            "onMinLimit,0,0",
            "onMaxLimit,10,9",
            "boundaryOutBelowMinLimit,-1,0",
            "boundaryOutAboveMaxLimit,11,0",
            "boundaryInNearMinLimit,1,0",
            "boundaryInNearMaxLimit,9,8"})
    void shouldDecreaseVolume(String testcase, int currentVolume, int expected) {
        radioman.setCurrentVolume(currentVolume);
        radioman.decreaseVolume();
        int actual = radioman.getCurrentVolume();
        assertEquals(expected, actual);
    }
}
