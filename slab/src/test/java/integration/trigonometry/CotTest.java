package integration.trigonometry;

import org.junit.jupiter.api.BeforeEach;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lab.tpo.trigonometry.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CotTest {
    private double accuracy = 1e-10;
    private Sin sinMock;
    private Cos cos;

    @BeforeEach
    public void initializeStub(){
        sinMock = mock(Sin.class);

        when(sinMock.apply(-3*Math.PI/2, accuracy)).thenReturn(1.0);
        when(sinMock.apply(-Math.PI, accuracy)).thenReturn(0.0);
        when(sinMock.apply(-Math.PI/2, accuracy)).thenReturn(-1.0);
        when(sinMock.apply(0.0, accuracy)).thenReturn(0.0);
        when(sinMock.apply(Math.PI/2, accuracy)).thenReturn(1.0);
        when(sinMock.apply(Math.PI, accuracy)).thenReturn(0.0);
        when(sinMock.apply(3*Math.PI/2, accuracy)).thenReturn(-1.0);
        when(sinMock.apply(2*Math.PI, accuracy)).thenReturn(0.0);
        when(sinMock.apply(5*Math.PI/2, accuracy)).thenReturn(1.0);
        cos = new Cos(sinMock);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2*Math.PI, 3*Math.PI/2, Math.PI, Math.PI/2, 0.0, -Math.PI/2, -Math.PI, -3*Math.PI/2, -2*Math.PI})
    public void testCosMockValues(double x){
        double expected = Math.cos(x);
        double actual = cos.apply(x, accuracy);
        assertEquals(expected, actual, 1e-8);
        verify(sinMock, times(1)).apply(Math.PI/2 - x, accuracy);
    }
}
