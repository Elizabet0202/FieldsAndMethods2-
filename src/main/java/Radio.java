public class Radio {
    private int currentStation = 0;
    private int currentVolume = 0;
    private int stationsCount;


    public Radio() {
        this.stationsCount = 10;
    }

    public Radio(int stationsCount) {
        if (stationsCount < 1) {
            this.stationsCount = 10;
        } else {
            this.stationsCount = stationsCount;
        }
    }

    public int getCurrentStation() {
        return currentStation;
    }

    public int getCurrentVolume() {
        return currentVolume;
    }

    public int getStationsCount() {
        return stationsCount;
    }

    public void next() {
        if (currentStation == stationsCount - 1) {
            currentStation = 0;
        } else {
            currentStation++;
        }
    }

    public void prev() {
        if (currentStation == 0) {
            currentStation = stationsCount - 1;
        } else {
            currentStation--;
        }
    }

    public void setStation(int number) {
        if (number >= 0 && number < stationsCount) {
            currentStation = number;
        }
    }

    public void increaseVolume() {
        if (currentVolume < 100) {
            currentVolume++;
        }
    }

    public void decreaseVolume() {
        if (currentVolume > 0) {
            currentVolume--;
        }
    }
}
