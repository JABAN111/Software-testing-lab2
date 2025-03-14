package integration.logarithm;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lab.tpo.logarithm.Ln;
import lab.tpo.logarithm.Log;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class LogIntegrationTest {
    private double accuracy = 1e-8;
    private Ln lnMock;
    private Log log;

    @BeforeEach
    public void initializeStub() {
        lnMock = mock(Ln.class);

        when(lnMock.apply(-1.0, accuracy)).thenReturn(Double.NaN);
        when(lnMock.apply(1.0, accuracy)).thenReturn(0.0);
        when(lnMock.apply(2.0, accuracy)).thenReturn(0.693147);
        when(lnMock.apply(3.0, accuracy)).thenReturn(1.09861228867);
        when(lnMock.apply(8.0, accuracy)).thenReturn(2.079441);
        when(lnMock.apply(10.0, accuracy)).thenReturn(2.30258509299);
        when(lnMock.apply(16.0, accuracy)).thenReturn(2.772588);
        when(lnMock.apply(20.0, accuracy)).thenReturn(2.99573227355);

        log = new Log(lnMock, 2);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 1.0, 2.0, 3.0, 8.0, 10.0, 16.0, 20.0 })
    public void testLogValues(double x) {
        double expected = Math.log(x) / Math.log(2.0);
        double actual = log.apply(x, accuracy);

        assertEquals(expected, actual, 1e-5);
    }

    @Test
    public void negativeX() {
        double expected = Double.NaN;
        assertEquals(expected, log.apply(-1, expected));
    }
}
