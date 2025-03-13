package lab.tpo.trigonometry;

import lab.tpo.FuncInterface;

public class Sec implements FuncInterface {

    private final Cos cos;

    public Sec(final Cos cos) {
        this.cos = cos;
    }

    @Override
    public double apply(double x, double accuracy) {
        var cosx = cos.apply(x, accuracy);
        if (cosx == 0) {
            return Double.NaN;
        }
        return 1 / cosx;
    }

}
