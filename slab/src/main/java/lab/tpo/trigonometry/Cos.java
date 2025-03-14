package lab.tpo.trigonometry;

import lab.tpo.FuncInterface;

public class Cos implements FuncInterface {

    private final Sin sin;

    public Cos(Sin sin) {
        this.sin = sin;
    }

    @Override
    public double apply(double x, double accuracy) {
        return sin.apply(Math.PI / 2 - x, accuracy);
    }

}
