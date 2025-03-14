package lab.tpo.trigonometry;

import lab.tpo.FuncInterface;

public class Cot implements FuncInterface {

    private final Sin sin;
    private final Cos cos;

    public Cot(final Sin sin, final Cos cos) {
        this.sin = sin;
        this.cos = cos;
    }

    @Override
    public double apply(double x, double accuracy) {
        double sinX = sin.apply(x, accuracy);
        double cosX = cos.apply(x, accuracy);

        if (sinX == 0 || x % Math.PI == 0) {
            return Double.NaN;
        }

        return cosX / sinX;
    }

}
