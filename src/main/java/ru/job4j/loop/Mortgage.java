package ru.job4j.loop;

public class Mortgage {
    public static int year(double amount, int salary, double percent) {
        int year = 0;
        for (int i = 0; i < amount; i++) {
            amount = amount + amount * percent / 100 - salary;
            year++;
        }
        return year;
    }
}