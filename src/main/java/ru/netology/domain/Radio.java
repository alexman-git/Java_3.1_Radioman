package ru.netology.domain;

public class Radio {
    public int currentStation;
    public int currentVolume;
    public int maxStation = 9;
    public int minStation = 0;
    public int maxVolume = 10;
    public int minVolume = 0;

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
