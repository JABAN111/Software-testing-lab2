package integration.func;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static java.lang.Math.pow;

import lab.tpo.func.TrigonometryFunc;
import lab.tpo.trigonometry.*;

public class TrigonometryFuncTest {

    private double accuracy = 1e-10;
    private Sec secMock;
    private Tan tanMock;
    private Sin sinMock;
    private Cot cotMock;
    private Csc cscMock;

    private TrigonometryFunc trigonometricFunc;

    @BeforeEach
    public void initializeStubs() {
        secMock = mock(Sec.class);
        tanMock = mock(Tan.class);
        sinMock = mock(Sin.class);
        cotMock = mock(Cot.class);
        cscMock = mock(Csc.class);

        when(secMock.apply(2.0, accuracy)).thenReturn(-2.40299796172);
        when(secMock.apply(-1.0, accuracy)).thenReturn(1.85081571768);
        when(secMock.apply(-5.0, accuracy)).thenReturn(3.52532008582);

        when(tanMock.apply(2.0, accuracy)).thenReturn(-2.18503986326);
        when(tanMock.apply(-1.0, accuracy)).thenReturn(-1.55740772465);
        when(tanMock.apply(-5.0, accuracy)).thenReturn(3.38051500625);

        when(sinMock.apply(2.0, accuracy)).thenReturn(0.909297426826);
        when(sinMock.apply(-1.0, accuracy)).thenReturn(-0.841470984808);
        when(sinMock.apply(-5.0, accuracy)).thenReturn(0.958924274663);

        when(cotMock.apply(2.0, accuracy)).thenReturn(-0.45765755436);
        when(cotMock.apply(-1.0, accuracy)).thenReturn(-0.642092615934);
        when(cotMock.apply(-5.0, accuracy)).thenReturn(0.295812915533);

        when(cotMock.apply(2.0, accuracy)).thenReturn(-0.45765755436);
        when(cotMock.apply(-1.0, accuracy)).thenReturn(-0.642092615934);
        when(cotMock.apply(-5.0, accuracy)).thenReturn(0.295812915533);

        when(cscMock.apply(2.0, accuracy)).thenReturn(1.09975017029);
        when(cscMock.apply(-1.0, accuracy)).thenReturn(-1.18839510578);
        when(cscMock.apply(-5.0, accuracy)).thenReturn(1.04283521277);

        this.trigonometricFunc = new TrigonometryFunc(secMock, tanMock, sinMock, cotMock, cscMock);
    }

    @ParameterizedTest
    @ValueSource(doubles = { 2.0, -1.0, -5.0 })
    public void testTrgFunc(double x) {
        var expected = (pow(secMock.apply(x, accuracy) + tanMock.apply(x, accuracy), 2) * sinMock.apply(x, accuracy))
                * (cotMock.apply(x, accuracy) / cscMock.apply(x, accuracy) + secMock.apply(x, accuracy))
                * (cscMock.apply(x, accuracy) + cotMock.apply(x, accuracy));

        double actual = trigonometricFunc.apply(x, accuracy);

        assertEquals(expected, actual, accuracy);
    }
}
