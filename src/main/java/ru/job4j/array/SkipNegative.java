package ru.job4j.array;

public class SkipNegative {
    public static int[][] skip(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int i1 = 0; i1 < array[i].length; i1++) {
                if (array[i][i1] < 0) {
                    array[i][i1] = 0;
                }
            }
        }
        return array;
    }
}