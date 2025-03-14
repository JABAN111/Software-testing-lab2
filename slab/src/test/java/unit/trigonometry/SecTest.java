package unit.trigonometry;

import org.junit.jupiter.api.Test;

import lab.tpo.export.CsvExporter;
import lab.tpo.trigonometry.*;

import static org.junit.jupiter.api.Assertions.*;

class SecTest {
    double eps = 1e-8;
    double accuracy = 1e-10;
    private final Sin sin = new Sin();
    private final Cos cos = new Cos(sin);
    private final Sec sec = new Sec(cos);
    private final CsvExporter csvExporter = new CsvExporter(sec::apply);

    @Test
    public void testAndSaveSecResults() {
        for (double x = -2 * Math.PI; x <= 2 * Math.PI; x += 0.1) {
            if (Math.cos(x) != 0) {
                double expected = 1 / Math.cos(x);
                double actual = sec.apply(x, accuracy);

                assertEquals(expected, actual, eps);
            }
        }
        csvExporter.testAndExportCsv(-2 * Math.PI, 2 * Math.PI, 0.1, "sec_results.csv", eps);
    }

}
