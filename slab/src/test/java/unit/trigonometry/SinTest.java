package unit.trigonometry;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import lab.tpo.trigonometry.Sin;

public class SinTest {
    private final Sin sin = new Sin();
    private final double accuracy = 1e-10;

    @Test
    public void SinPositiveValuesTest() {
        assertEquals(sin.apply(1, accuracy), 0.841470984808, accuracy);
        assertEquals(sin.apply(5, accuracy), -0.958924274663, accuracy);
        assertEquals(sin.apply(15, accuracy), 0.650287840157, accuracy);
    }

    @Test
    public void SinNegativeValuesTest() {
        assertEquals(sin.apply(-1, accuracy), -0.841470984808, accuracy);
        assertEquals(sin.apply(-5, accuracy), 0.958924274663, accuracy);
        assertEquals(sin.apply(-15, accuracy), -0.650287840157, accuracy);
    }

}
