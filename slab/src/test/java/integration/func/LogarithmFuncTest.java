package integration.func;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Math.pow;


import lab.tpo.func.LogarithmFunc;
import lab.tpo.logarithm.Ln;
import lab.tpo.logarithm.Log;

public class LogarithmFuncTest {

    private double accuracy = 1e-15;
    private Ln lnMock;
    private Log log2Mock;
    private Log log10Mock;
    private LogarithmFunc logarithmFunction;


    @BeforeEach
    public void setUp() {
        lnMock = mock(Ln.class);
        log2Mock = mock(Log.class);
        log10Mock = mock(Log.class);

        when(lnMock.apply(2.0, accuracy)).thenReturn(0.69314718056);
        when(lnMock.apply(5.0, accuracy)).thenReturn(1.60943791243);
        when(lnMock.apply(3.0, accuracy)).thenReturn(1.09861228867);

        when(log2Mock.apply(2.0, accuracy)).thenReturn(1.0);
        when(log2Mock.apply(5.0, accuracy)).thenReturn(2.32192809489);
        when(log2Mock.apply(3.0, accuracy)).thenReturn(1.58496250072);

        when(log10Mock.apply(2.0, accuracy)).thenReturn(0.301029995664);
        when(log10Mock.apply(5.0, accuracy)).thenReturn(0.698970004336);
        when(log10Mock.apply(3.0, accuracy)).thenReturn(0.47712125472);

        logarithmFunction = new LogarithmFunc(lnMock, log2Mock, log10Mock);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2.0, 3.0, 5.0})
    public void testLogarithmFunction(double x){
        double expected = pow(pow(pow(log2Mock.apply(x, accuracy), 3) * lnMock.apply(x, accuracy), 2), 3) * log10Mock.apply(x, accuracy);
        double actual = logarithmFunction.apply(x, accuracy);

        assertEquals(expected, actual, accuracy);
    }


}
