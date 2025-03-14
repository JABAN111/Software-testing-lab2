package lab.tpo.trigonometry;

import lab.tpo.FuncInterface;

public class Csc implements FuncInterface {
    private final Sin sin;

    public Csc(final Sin sin) {
        this.sin = sin;
    }

    @Override
    public double apply(double x, double accuracy) {
        var sinx = sin.apply(x, accuracy);
        if (sinx == 0) {
            return Double.NaN;
        }
        return 1 / sinx;
    }

}
