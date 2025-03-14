package unit.function;

import org.junit.jupiter.api.Test;

import lab.tpo.export.CsvExporter;
import lab.tpo.func.LogarithmFunc;
import lab.tpo.logarithm.*;

import static org.junit.jupiter.api.Assertions.*;

public class LogarithmFuncTest {
    private final Ln ln = new Ln();
    private final Log log2 = new Log(ln, 2);
    private final Log log10 = new Log(ln, 10);
    private final LogarithmFunc logFunction = new LogarithmFunc(ln, log2, log10);
    double accuracy = 1e-10;
    private final double eps = 1e-5;
    private final CsvExporter csvExporter = new CsvExporter(logFunction::apply);

    @Test
    public void testAndSaveLogFunctionResults() {
        csvExporter.testAndExportCsv(0.1, 10.0, 0.1, "log_func_result.csv", eps);
    }

    @Test
    public void testValues() {
        assertEquals(5.0322614536 * Math.pow(10, -8), logFunction.apply(1.5, accuracy), eps);
        assertEquals(-35.7897246212, logFunction.apply(0.4, accuracy), eps);
        assertEquals(-0.0333858577502, logFunction.apply(0.5, accuracy), eps);
        assertEquals(-0.0000162085013759, logFunction.apply(0.6, accuracy), eps);
        assertEquals(0.0333858577502, logFunction.apply(2, accuracy), eps);
        assertEquals(35.7897246212, logFunction.apply(2.5, accuracy), eps);
        assertEquals(102.052429114, logFunction.apply(2.6, accuracy), eps);
        assertEquals(268.787913904, logFunction.apply(2.7, accuracy), eps);
    }

}