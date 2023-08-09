package ru.job4j.calculator;

import static ru.job4j.math.MathFunction.*;

public class MathCalculator {
    public static double sumAndMultiply(double first, double second) {
        return sum(first, second)
                + multiply(first, second);
    }

    public static double divisionAndDifference(double first, double second) {
        return division(first, second)
                + difference(first, second);
    }

    public static double mathematicalOperations(double first, double second) {
        return division(first, second)
                + difference(first, second)
                + sum(first, second)
                + multiply(first, second);
    }

    public static void main(String[] args) {
        System.out.println("Результат расчета равен: " + sumAndMultiply(10, 20));
        System.out.println("Результат расчета равен метода divisionAndDifference: " + divisionAndDifference(10, 20));
        System.out.println("Результат расчета равен метода mathematicalOperations: " + mathematicalOperations(10, 20));
    }
}