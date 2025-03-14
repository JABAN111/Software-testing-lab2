package lab.tpo.export;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.function.BiFunction;

public class CsvExporter {
    private final BiFunction<Double, Double, Double> moduleFunction;

    public CsvExporter(BiFunction<Double, Double, Double> moduleFunction) {
        this.moduleFunction = moduleFunction;
    }

    public void export(double startX, double endX, double step, double eps, String filePath, String delimiter) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.append("X").append(delimiter).append("Result").append("\n");

            for (double x = startX; x <= endX; x += step) {
                double result = moduleFunction.apply(x, eps);
                writer.append(String.valueOf(x))
                        .append(delimiter)
                        .append(String.valueOf(result))
                        .append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException("Failed to write into file");
        }
    }

    public void testAndExportCsv(double startX, double endX, double step, String filename, double eps) {
        String resourcesPath = Paths.get("src", "test", "resources").toString();
        new File(resourcesPath).mkdirs();
        String filePath = Paths.get(resourcesPath, filename).toString();
        this.export(startX, endX, step, eps, filePath, ",");
        System.out.println("File created: " + filePath);
    }

}
