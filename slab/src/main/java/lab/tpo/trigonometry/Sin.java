package lab.tpo.trigonometry;

import lab.tpo.FuncInterface;

public class Sin implements FuncInterface {

    @Override
    public double apply(double x, double accuracy) {
        double term = x;
        double sum = term;
        int i = 1;
        while(Math.abs(term) > accuracy){
            term *= -x*x / ((2*i)*(2*i+1));
            sum += term;
            i++;
        }
        return sum;
     }
    
}
