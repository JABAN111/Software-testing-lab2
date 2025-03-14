package lab.tpo.logarithm;

import lab.tpo.FuncInterface;

public class Ln implements FuncInterface {

    public double apply(double x, double accuracy) {
        if (x == 0) {
            return Double.NEGATIVE_INFINITY;
        }

        if (x < 0) {
            return Double.NaN;
        }

        double y = (x - 1) / (x + 1);
        double sum = 0.0;
        double term = y;
        int n = 1;

        while (Math.abs(term) > accuracy) {
            sum += term / (2 * n - 1);
            term *= y * y;
            n++;
        }
        return 2 * sum;
    }

}
