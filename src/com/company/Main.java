package com.company;

public class Main {
    private static final double MIN_RANGE = -5;
    private static final double MAX_RANGE = 5;
    private static final double EPS = 0.0001;

    public static void main(String[] args) {

        double x = 0;
        System.out.println("Function\n   e^x - 10x = 0");
        System.out.printf("Segment: [%.2f, %.2f];\n", MIN_RANGE, MAX_RANGE);
        System.out.printf(" Intermediate root: %.2f\n\n", x);

        double result;
        double a = Math.exp(MIN_RANGE) - 10;
        double b = Math.exp(MAX_RANGE) - 10;
        double c = Math.exp(x) - 10;
        if (a > b && a > c) {
            x = MIN_RANGE;
        } else {
            if (b > a && b > c) {
                x = MAX_RANGE;
            }
        }

        double lambda = 1. / (Math.exp(x) - 10);
        System.out.printf("Initial x for iterations: %.2f;\n", x);
        System.out.printf("Lambda: %.5f;\n\n", lambda);

        double x0;
        double fx;
        int count = 0;
        System.out.printf("%s %8s %15s\n", "Iterations", "x", "f(x)");
        do {
            x0 = x;
            x = x - lambda * (Math.exp(x) - 10 * x);
            fx = Math.exp(x) - 10 * x;
            System.out.printf("%5d %15.8f %15.8f\n", ++count, x0, fx);
        } while (Math.abs(x - x0) > EPS);

        result = x0;
        System.out.printf("\nAnswer:\n   x = %.8f;", result);
    }

}