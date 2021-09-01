import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestJulianDate {

    private static JulianDate juliandate;

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        juliandate = new JulianDate(2021, 5, 23, 14, 45, 32);
    }

    @BeforeEach
    void setUp() throws Exception {
    }

    @Test
    void testtomorrow() {
        assertEquals(LocalDateTime.now().plusDays(1).withNano(0), juliandate.tomorrow().withNano(0));
    }

    void testyesterday() {
        assertEquals(LocalDateTime.now().minusDays(1).withNano(0), juliandate.yesterday().withNano(0));
    }

    void testdaysBetween() {
        assertEquals(10.0, juliandate.daysBetween(LocalDateTime.of(2021, Month.MAY, 20, 18, 4, 23),
                LocalDateTime.of(2021, Month.MAY, 30, 18, 4, 23)));
    }

    void testgetJD() {
        assertEquals(juliandate.calculateJD(0, 0, 0, 0, 0, 0), juliandate.getJD());
    }
}
