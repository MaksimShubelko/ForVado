package com.company;

public class Function {
    public static double getValue(double x) {
        return Math.exp(x) - 10 * x;
    }

    public static double getDerivative(double x) {
        return Math.exp(x) - 10;
    }
}
