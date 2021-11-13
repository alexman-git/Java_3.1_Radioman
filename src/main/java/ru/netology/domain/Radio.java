package ru.netology.domain;

public class Radio {
    private int numberOfStations = 10;
    private int currentStation;
    private int currentVolume;
    private int maxStation = 9;
    private int minStation = 0;
    private int maxVolume = 100;
    private int minVolume = 0;

    public Radio() {
    }

    public Radio(int numberOfStations) {
        if (numberOfStations > 0) {
            this.numberOfStations = numberOfStations;
            this.maxStation = numberOfStations - 1;
        } else {
            return;
        }
    }

    public int getNumberOfStations() {
        return numberOfStations;
    }

    public void setNumberOfStations(int numberOfStations) {
        if (numberOfStations > 0) {
            this.numberOfStations = numberOfStations;
        } else {
            return;
        }
    }

    // 1) станции
    public int getCurrentStation() {
        return currentStation;
    }

    public void setCurrentStation(int currentStation) {
        if (currentStation <= maxStation && currentStation >= minStation) {
            this.currentStation = currentStation;
        } else {
            return;
        }
    }

    public void shiftNextStation() {
        if (currentStation == maxStation) {
            setCurrentStation(minStation);
        } else {
            currentStation++;
        }
    }

    public void shiftPrevStation() {
        if (currentStation == minStation) {
            setCurrentStation(maxStation);
        } else {
            currentStation--;
        }
    }

    // 2) звук
    public int getCurrentVolume() {
        return currentVolume;
    }

    public void setCurrentVolume(int currentVolume) {
        if (currentVolume <= maxVolume && currentVolume >= minVolume) {
            this.currentVolume = currentVolume;
        } else {
            return;
        }
    }

    public void increaseVolume() {
        if (currentVolume == maxVolume) {
            return;
        } else {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume == minVolume) {
            return;
        } else {
            currentVolume--;
        }
    }
}
