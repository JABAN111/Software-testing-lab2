package unit.trigonometry;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lab.tpo.export.CsvExporter;
import lab.tpo.trigonometry.*;



import static org.junit.jupiter.api.Assertions.*;

class CosTest {
    double accuracy = 1e-10;
    double eps = 1e-8;
    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);
    private final CsvExporter csvExporter = new CsvExporter(cos::apply);

    @Test
    public void testAndSaveCosResults(){
        for (double x = 0; x <= 2*Math.PI; x += 0.1) {
            double expected = Math.cos(x);
            double actual = cos.apply(x, accuracy);

            assertEquals(expected, actual, eps);

        }
        csvExporter.testAndExportCsv(0, 2*Math.PI, 0.1,"cos_result.csv", eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {2*Math.PI, Math.PI, 0.5*Math.PI, 0.25*Math.PI})
    public void testPositiveValues(double x){
        assertEquals(Math.cos(x), cos.apply(x,accuracy),eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = {-2*Math.PI, -Math.PI, -0.5*Math.PI})
    public void testNegativeValues(double x){
        assertEquals(Math.cos(x), cos.apply(x, accuracy), eps);
    }

    @Test
    public void testZeroValue(){
        double value = 0;
        double expectedRes = Math.cos(value);
        double actualRes = cos.apply(value, accuracy);
        assertEquals(expectedRes, actualRes, eps);
    }
}