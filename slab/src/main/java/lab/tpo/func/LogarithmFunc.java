package lab.tpo.func;

import lab.tpo.FuncInterface;
import lab.tpo.logarithm.Ln;
import lab.tpo.logarithm.Log;

import static java.lang.Math.pow;

public class LogarithmFunc implements FuncInterface {

    private final Ln ln;
    private final Log log2;
    private final Log log10;

    public LogarithmFunc(Ln ln, Log log2, Log log10) {
        this.ln = ln;
        this.log2 = log2;
        this.log10 = log10;
    }

    /**
     * x > 0 : ((((
     * (log_2(x) ^ 3) * ln(x)
     * ) ^ 2) ^ 3) * log_10(x))
     * 
     */
    @Override
    public double apply(double x, double accuracy) {
        return pow(pow(pow(log2.apply(x, accuracy), 3) * ln.apply(x, accuracy), 2), 3) * log10.apply(x, accuracy);
    }

}
