package unit.function;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lab.tpo.export.CsvExporter;
import lab.tpo.func.LogarithmFunc;
import lab.tpo.func.MainFunction;
import lab.tpo.func.TrigonometryFunc;
import lab.tpo.logarithm.*;
import lab.tpo.trigonometry.*;


import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainFunctionTest {
    private static final double accuracy = 1e-10;

    private final Ln ln = new Ln();
    private final Log log2 = new Log(ln, 2);
    private final Log log10 = new Log(ln, 10);
    private final LogarithmFunc logarithmFunc = new LogarithmFunc(ln, log2, log10);

    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);
    private final Tan tan = new Tan(sin, cos);
    private final Cot cot = new Cot(sin, cos);
    private final Csc csc = new Csc(sin);
    private final Sec sec = new Sec(cos);
    
    private final TrigonometryFunc trigonometricFunc = new TrigonometryFunc(sec, tan, sin, cot, csc);
    private final MainFunction mainFunc = new MainFunction(logarithmFunc, trigonometricFunc);
    
    private final CsvExporter csvExporter = new CsvExporter(mainFunc::apply);

    @Test
    public void testAndSaveTrigFunc(){
        csvExporter.testAndExportCsv(0.1, 20, 0.1, "main_result.csv", accuracy);
    }

    @ParameterizedTest
    @ValueSource(doubles = {0.2, 0.7, 1.5, 2, 2.5, 2.6, 3, 4, 5, 6, 7, 10, 20})
    public void testMainFuncPositive(double x){
        double expected = logarithmFunc.apply(x, accuracy);
        double actual = mainFunc.apply(x, accuracy);
        assertEquals(expected, actual, accuracy);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-0.2, -0.7, -1.5, -2, -2.5, -2.6, -3, -4, -5, -6, -7, -10, -20})
    public void testMainFunctionNegative(double x){
        double expected = trigonometricFunc.apply(x, accuracy);
        double actual = mainFunc.apply(x, accuracy);
        assertEquals(expected, actual, accuracy);
    }
}
