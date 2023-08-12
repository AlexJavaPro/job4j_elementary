package ru.job4j.array;

public class Check {
    public static boolean mono(boolean[] data) {
        boolean result = true;
        int countTrue = 0;
        int countFalse = 0;
        for (int i = 0; i < data.length; i++) {
            if (data[i]) {
                countTrue++;
            }
            if (!data[i]) {
                countFalse++;
            }
        }
        if (countTrue != 0 && countFalse != 0) {
            result = false;
        }
        return result;
    }
}