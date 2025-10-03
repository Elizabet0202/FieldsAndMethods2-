import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RadioTest {
    private Radio radio;

    @BeforeEach
    void setup() {
        radio = new Radio();
    }

    @Test
    void testNextStationWrapsFrom9To0() {
        radio.setStation(9);
        radio.next();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testNextStationNormalIncrement() {
        radio.setStation(8);
        radio.next();
        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testPrevStationWrapsFrom0To9() {
        radio.setStation(0);
        radio.prev();
        Assertions.assertEquals(9, radio.getCurrentStation());
    }

    @Test
    void testPrevStationNormalDecrement() {
        radio.setStation(1);
        radio.prev();
        Assertions.assertEquals(0, radio.getCurrentStation());
    }

    @Test
    void testSetStationValid() {
        radio.setStation(5);
        Assertions.assertEquals(5, radio.getCurrentStation());
    }

    @Test
    void testSetStationInvalidLowerBound() {
        radio.setStation(4);
        radio.setStation(-1);
        Assertions.assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void testSetStationInvalidUpperBound() {
        radio.setStation(4);
        radio.setStation(10);
        Assertions.assertEquals(4, radio.getCurrentStation());
    }

    @Test
    void testIncreaseVolumeMax() {
        for (int i = 0; i < 100; i++) {
            radio.increaseVolume();
        }
        Assertions.assertEquals(100, radio.getCurrentVolume());
        radio.increaseVolume();
        Assertions.assertEquals(100, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolumeMin() {
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
        radio.increaseVolume();
        Assertions.assertEquals(1, radio.getCurrentVolume());
        radio.decreaseVolume();
        Assertions.assertEquals(0, radio.getCurrentVolume());
    }

    @Test
    void testIncreaseVolumeNorma() {
        radio.setStation(5);
        radio.increaseVolume();
        Assertions.assertEquals(1, radio.getCurrentVolume());
    }

    @Test
    void testDecreaseVolumeNormal() {
        for (int i = 0; i < 5; i++) {
            radio.increaseVolume();
        }
        radio.decreaseVolume();
        Assertions.assertEquals(4, radio.getCurrentVolume());
    }
}

