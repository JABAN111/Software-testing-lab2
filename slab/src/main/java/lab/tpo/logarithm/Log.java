package lab.tpo.logarithm;

import lab.tpo.FuncInterface;

public class Log implements FuncInterface {

    private Ln ln = new Ln();
    private final int base;

    public Log(Ln ln, int base) {
        this.ln = ln;
        this.base = base;
    }

    @Override
    public double apply(double x, double accuracy) {
        if (this.base <= 1) {
            return Double.NaN;
        }
        return ln.apply(x, accuracy) / ln.apply(base, accuracy);
    }
}
