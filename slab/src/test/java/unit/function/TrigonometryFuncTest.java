package unit.function;


import org.junit.jupiter.api.Test;

import lab.tpo.export.CsvExporter;
import lab.tpo.func.TrigonometryFunc;
import lab.tpo.trigonometry.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TrigonometryFuncTest {
    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);
    private final Tan tan = new Tan(sin, cos);
    private final Cot cot = new Cot(sin, cos);
    private final Csc csc = new Csc(sin);
    private final Sec sec = new Sec(cos);
    private final TrigonometryFunc trigonometricFunc = new TrigonometryFunc(sec, tan, sin, cot, csc);

    private final double accuracy = 1e-8;
    private final CsvExporter csvExporter = new CsvExporter(trigonometricFunc::apply);

    @Test
    public void testAndSaveTrigFunc(){
        csvExporter.testAndExportCsv(-10.0, -0.1, 0.1, "trig_func_result.csv", accuracy);
    }


    @Test
    public void testValues(){
        assertEquals(2.64795248342, trigonometricFunc.apply(-0.2, accuracy), accuracy);
        assertEquals(2.12877144787, trigonometricFunc.apply(-0.3, accuracy), accuracy);
        assertEquals(1.6941368498, trigonometricFunc.apply(-0.4, accuracy), accuracy);
        assertEquals(1.33263482247, trigonometricFunc.apply(-0.5, accuracy), accuracy);
        assertEquals(1.03456315637, trigonometricFunc.apply(-0.6, accuracy), accuracy);
    }
}

