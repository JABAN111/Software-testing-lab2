package integration.trigonometry;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lab.tpo.trigonometry.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

public class TanTest {
    private double accuracy = 1e-10;
    private Sin sinMock;
    private Cos cosMock;
    private Tan tan;

    @BeforeEach
    public void initializeStub() {
        sinMock = mock(Sin.class);
        cosMock = mock(Cos.class);

        when(sinMock.apply(-3 * Math.PI / 2, accuracy)).thenReturn(1.0);
        when(sinMock.apply(-Math.PI, accuracy)).thenReturn(0.0);
        when(sinMock.apply(-Math.PI / 2, accuracy)).thenReturn(-1.0);
        when(sinMock.apply(0.0, accuracy)).thenReturn(0.0);
        when(sinMock.apply(Math.PI / 2, accuracy)).thenReturn(1.0);
        when(sinMock.apply(Math.PI, accuracy)).thenReturn(0.0);

        when(sinMock.apply(3 * Math.PI / 2, accuracy)).thenReturn(-1.0);
        when(cosMock.apply(-3 * Math.PI / 2, accuracy)).thenReturn(0.0);
        when(cosMock.apply(-Math.PI, accuracy)).thenReturn(-1.0);
        when(cosMock.apply(-Math.PI / 2, accuracy)).thenReturn(0.0);
        when(cosMock.apply(0.0, accuracy)).thenReturn(1.0);
        when(cosMock.apply(Math.PI / 2, accuracy)).thenReturn(0.0);
        when(cosMock.apply(Math.PI, accuracy)).thenReturn(-1.0);
        when(cosMock.apply(3 * Math.PI / 2, accuracy)).thenReturn(0.0);

        tan = new Tan(sinMock, cosMock);

    }

    @ParameterizedTest
    @ValueSource(doubles = { -3 * Math.PI / 2, -Math.PI, -Math.PI / 2, 0.0, Math.PI / 2, Math.PI, 3 * Math.PI / 2 })
    public void testTanMockValues(double x) {
        double expected = Math.tan(x);
        double actual = tan.apply(x, accuracy);

        if (Math.abs((x % Math.PI) - Math.PI / 2) < 1e-10 || x == -3 * Math.PI / 2 || x == -Math.PI / 2) {
            assertTrue(Double.isNaN(actual));
        } else {
            assertEquals(expected, actual, 1e-8);
        }

        verify(sinMock, times(1)).apply(x, accuracy);
        verify(cosMock, times(1)).apply(x, accuracy);
    }

}
