package lab.tpo.func;

public class MainFunction {

    private final LogarithmFunc logarithmFunc;
    private final TrigonometryFunc trigonometryFunc;

    public MainFunction(LogarithmFunc logarithmFunc, TrigonometryFunc trigonometryFunc) {
        this.logarithmFunc = logarithmFunc;
        this.trigonometryFunc = trigonometryFunc;
    }

    public double apply(double x, double accuracy) {
        if (x > 0) {
            return logarithmFunc.apply(x, accuracy);
        }

        return trigonometryFunc.apply(x, accuracy);
    }
}
