package integration.func;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import lab.tpo.func.LogarithmFunc;
import lab.tpo.func.MainFunction;
import lab.tpo.func.TrigonometryFunc;

public class MainFuncTest {
    private final double accuracy = 1e-10;
    private LogarithmFunc logarithmFuncMock;
    private TrigonometryFunc trigonometricFuncMock;
    private MainFunction mainFunc;


    @BeforeEach
    public void setUp(){
        logarithmFuncMock = mock(LogarithmFunc.class);
        trigonometricFuncMock = mock(TrigonometryFunc.class);

        when(logarithmFuncMock.apply(1.0, accuracy)).thenReturn(0d);
        when(trigonometricFuncMock.apply(-5.0, accuracy)).thenReturn(233.180433776);

        mainFunc = new MainFunction(logarithmFuncMock, trigonometricFuncMock);
    }


    @Test
    public void testMainFunction_Logarithmic() {
        double x = 1.0;
        double expected = 0d;
        double actual = mainFunc.apply(x, accuracy);

        assertEquals(expected, actual, accuracy);

        verify(logarithmFuncMock, times(1)).apply(x, accuracy);
        verify(trigonometricFuncMock, times(0)).apply(x, accuracy);
    }

    @Test
    public void testMainFuncTrigonometry(){
        var x = -5d;
        var expected = 233.180433776;
        double actual = mainFunc.apply(x, accuracy);

        assertEquals(expected, actual, accuracy);

        verify(logarithmFuncMock, times(0)).apply(x, accuracy);
        verify(trigonometricFuncMock, times(1)).apply(x, accuracy);
    }
}
