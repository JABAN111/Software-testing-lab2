package unit.trigonometry;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import lab.tpo.export.CsvExporter;
import lab.tpo.trigonometry.*;

import static org.junit.jupiter.api.Assertions.*;

public class CosecTest {
    double eps = 1e-8;
    double accuracy = 1e-10;
    private final Sin sin = new Sin();
    private final Csc csc = new Csc(sin);
    private final CsvExporter csvExporter = new CsvExporter(csc::apply);

    @Test
    public void testAndSaveCosecResults() {
        for (double x = 0.1; x <= 2 * Math.PI; x += 0.1) {
            double expected = 1 / Math.sin(x);
            double actual = csc.apply(x, accuracy);

            assertEquals(expected, actual, eps);

        }
        csvExporter.testAndExportCsv(0.1, 2 * Math.PI, 0.1, "cosec_results.csv", eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = { Math.PI / 6, Math.PI / 4, Math.PI / 3, Math.PI / 2 })
    public void testPiValues(double x) {
        assertEquals(1 / Math.sin(x), csc.apply(x, accuracy), eps);
    }

    @ParameterizedTest
    @ValueSource(doubles = { Math.PI / 6, Math.PI / 4, Math.PI / 3, Math.PI / 2 })
    public void testNegativePi(double x) {
        assertEquals(1 / Math.sin(x), csc.apply(x, accuracy), eps);
    }

}