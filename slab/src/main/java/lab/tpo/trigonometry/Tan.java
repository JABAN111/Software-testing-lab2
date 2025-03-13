package lab.tpo.trigonometry;

import lab.tpo.FuncInterface;

public class Tan implements FuncInterface {
    private final Sin sin;
    private final Cos cos;

    public Tan(Sin sin, Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public double apply(double x, double accuracy) {
        var sinX = sin.apply(x, accuracy);
        var cosX = cos.apply(x, accuracy);

        if (cosX == 0) {
            return Double.NaN;
        }

        return sinX / cosX;
    }

}
