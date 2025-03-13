package integration.trigonometry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lab.tpo.trigonometry.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class SecTest {
    private double accuracy = 1e-10;
    private Cos cosMock;
    private Sec sec;

    @BeforeEach
    public void initializeStub() {
        cosMock = mock(Cos.class);

        when(cosMock.apply(-Math.PI, accuracy)).thenReturn(-1.0);
        when(cosMock.apply(-Math.PI / 2, accuracy)).thenReturn(0.0);
        when(cosMock.apply(0.0, accuracy)).thenReturn(1.0);
        when(cosMock.apply(Math.PI / 2, accuracy)).thenReturn(0.0);
        when(cosMock.apply(Math.PI, accuracy)).thenReturn(-1.0);
        when(cosMock.apply(3 * Math.PI / 2, accuracy)).thenReturn(0.0);

        sec = new Sec(cosMock);
    }

    @ParameterizedTest
    @ValueSource(doubles = { -Math.PI, -Math.PI / 2, 0.0, Math.PI / 2, Math.PI, 3 * Math.PI / 2 })
    public void testSecMockValues(double x) {
        double cosValue = Math.cos(x);
        if (Math.abs(cosValue) < 1e-10) {
            assertTrue(Double.isNaN(sec.apply(x, accuracy)));
        } else {
            double expected = 1 / cosValue;
            double actual = sec.apply(x, accuracy);
            assertEquals(expected, actual, 1e-8);
        }

        verify(cosMock, times(1)).apply(x, accuracy);
    }
}