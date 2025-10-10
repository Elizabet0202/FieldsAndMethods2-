import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RadioTest {
    private Radio radio;

    @Test
    void defaultConstructorSetsStationsCountTo10() {
        radio = new Radio();
        Assertions.assertEquals(10, radio.getStationsCount());
    }

    @Test
    void parameterizedConstructorSetsStationsCount() {
        radio = new Radio(15);
        Assertions.assertEquals(15, radio.getStationsCount());
        radio = new Radio(0);
        Assertions.assertEquals(10, radio.getStationsCount());
    }

    @Test
    void nextWrapsWithFlexibleStations() {
        radio = new Radio(5);
        radio.setStation(4);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void prevWrapsWithFlexibleStations() {
        radio = new Radio(7);
        radio.setStation(0);
        radio.prev();
        Assertions.assertEquals(6, radio.getCurrentStation());
    }

    @Test
    void setStationRespectsStationsCount() {
        radio = new Radio(3);
        radio.setStation(2);
        Assertions.assertEquals(2, radio.getCurrentStation());
        radio.setStation(3);
        Assertions.assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void setStationWithinBounds() {
        radio = new Radio(3);
        radio.setStation(1);
        Assertions.assertEquals(1, radio.getCurrentStation());
    }

    @Test
    void setStationOutOfBounds() {
        radio = new Radio(3);
        radio.setStation(2);
        radio.setStation(5);
        Assertions.assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void volumeGetterReturnsCurrentVolume() {
        radio = new Radio();
        radio.increaseVolume();
        Assertions.assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void testIncreaseVolumeWithinLimit() {
        radio = new Radio();
        while (radio.getCurrentVolume() < 99) {
            radio.increaseVolume();
        }
        int volumeBefore = radio.getCurrentVolume();
        radio.increaseVolume();
        Assertions.assertEquals(volumeBefore + 1, radio.getCurrentVolume());
    }

    @Test
    void testIncreaseVolumeAtLimit() {
        radio = new Radio();
        while (radio.getCurrentVolume() < 100) {
            radio.increaseVolume();
        }
        int volumeBefore = radio.getCurrentVolume();
        radio.increaseVolume();
        Assertions.assertEquals(volumeBefore, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolumeWithinLimit() {
        radio = new Radio();
        while (radio.getCurrentVolume() < 10) {
            radio.increaseVolume();
        }
        int volumeBefore = radio.getCurrentVolume();
        radio.decreaseVolume();
        Assertions.assertEquals(volumeBefore - 1, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolumeAtLimit() {
        radio = new Radio();
        int volumeBefore = radio.getCurrentVolume();
        radio.decreaseVolume();
        Assertions.assertEquals(volumeBefore, radio.getCurrentVolume());
    }

    @Test
    void testNext_stationAtMax_wrapsToZero() {
        Radio radio = new Radio(5);
        radio.setStation(4);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testNext_stationNotMax_increments() {
        Radio radio = new Radio(5);
        radio.setStation(2);
        radio.next();
        Assertions.assertEquals(3, radio.getCurrentStation());
    }

    @Test
    void testPrev_stationAtZero_wrapsToMax() {
        Radio radio = new Radio(5);
        radio.setStation(0);
        radio.prev();
        Assertions.assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void testPrev_stationNotZero_decrements() {
        Radio radio = new Radio(5);
        radio.setStation(3);
        radio.prev();
        Assertions.assertEquals(2, radio.getCurrentStation());
    }

    @Test
    void testSetStation_validNumber_changesStation() {
        Radio radio = new Radio(5);
        radio.setStation(3);
        Assertions.assertEquals(3, radio.getCurrentStation());
    }

    @Test
    void testSetStation_invalidNumber_doesNotChangeStation() {
        Radio radio = new Radio(5);
        radio.setStation(2);
        radio.setStation(5);
        Assertions.assertEquals(2, radio.getCurrentStation());
        radio.setStation(-1);
        Assertions.assertEquals(2, radio.getCurrentStation());
    }
}
