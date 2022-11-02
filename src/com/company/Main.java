package com.company;

public class Main {
    private static final double MIN_RANGE = -5;
    private static final double MAX_RANGE = 5;
    private static final double EPS = 0.0001;

    /**
     * Метод находит начальное значение для х.
     * Как он работает? Мы подставляем в производную формулы
     * minRange, maxRange и x и выбираем fmax. (максимальный результат)
     *
     * @param minRange - минимальный корень для значения х;
     * @param maxRange - максимальный корень для значения х;
     * @param x        - корень, найденный из уравнения;
     * @return начальное значение для х для итерации
     */
    public static double searchX(double minRange, double maxRange, double x) {
        double a = Function.getDerivative(minRange);
        double b = Function.getDerivative(maxRange);
        double c = Function.getDerivative(x);
        return a >= b && a >= c ? minRange : b >= a && b >= c ? maxRange : x;
    }

    /**
     * Т.к. конечная формула для итерации равна x - lambda * f(x),
     * то этим методом мы находим значение лямбды
     *
     * @param x - начальное найденное значение для итераций
     * @return лямбду
     */
    public static double getLambda(double x) {
        return 1. / (Function.getDerivative(x));
    }

    /**
     * Ищем итерацией решение функции с погрешностью.
     *
     * @param lambda - лямбда;
     * @param x      - начальное значение х для итераций;
     * @param eps    - погрешность;
     * @return возвращаем решение
     */
    private static double function(double lambda, double x, double eps) {
        double x0;
        double fx;
        int count = 0;
        System.out.printf("%s %8s %15s\n", "Iterations", "x", "f(x)");
        do {
            x0 = x;
            x = x - lambda * Function.getValue(x);
            fx = Function.getValue(x);
            System.out.printf("%5d %15.8f %15.8f\n", ++count, x0, fx);
        } while (Math.abs(x - x0) >= eps);
        return x0;
    }


    public static void main(String[] args) {

        double x = 0;
        System.out.println("Function\n   e^x - 10x = 0");
        System.out.printf("Segment: [%.2f, %.2f];\n", MIN_RANGE, MAX_RANGE);
        System.out.printf(" Intermediate root: %.2f\n\n", x);

        x = searchX(MIN_RANGE, MAX_RANGE, x);
        double lambda = getLambda(x);
        System.out.printf("Initial x for iterations: %.2f;\n", x);
        System.out.printf("Lambda: %.5f;\n\n", lambda);

        double result = function(lambda, x, EPS);
        System.out.printf("\nAnswer:\n   x = %.8f;", result);
    }
}