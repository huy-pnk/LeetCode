package org.medium;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class Pow {
    public double myPow(double x, int n) {
        int pow = Math.abs(n);
        double result = DoubleStream.generate(() -> x).parallel().limit(pow).reduce(1, (a,b)->a*b);
        if(n<0)return 1/result;
        return result;
    }
}
