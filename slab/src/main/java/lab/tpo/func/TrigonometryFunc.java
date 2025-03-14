package lab.tpo.func;

import lab.tpo.FuncInterface;
import lab.tpo.trigonometry.*;

import static java.lang.Math.pow;

public class TrigonometryFunc implements FuncInterface {

    private final Sec sec;
    private final Tan tan;
    private final Sin sin;
    private final Cot cot;
    private final Csc csc;

    public TrigonometryFunc(Sec sec, Tan tan, Sin sin, Cot cot, Csc csc) {
        this.sec = sec;
        this.tan = tan;
        this.sin = sin;
        this.cot = cot;
        this.csc = csc;
    }

    // (((((sec(x) + tan(x)) ^ 2) * sin(x)) * ((cot(x) / csc(x)) + sec(x))) *
    // (csc(x) + cot(x)))
    @Override
    public double apply(double x, double accuracy) {
        return (pow(sec.apply(x, accuracy) + tan.apply(x, accuracy), 2) * sin.apply(x, accuracy))
                * (cot.apply(x, accuracy) / csc.apply(x, accuracy) + sec.apply(x, accuracy))
                * (csc.apply(x, accuracy) + cot.apply(x, accuracy));
    }

}
