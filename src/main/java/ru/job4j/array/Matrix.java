package ru.job4j.array;

public class Matrix {
    public static int[][] multiple(int size) {
        int[][] table = new int[size][size];
        for (int i = 0; i < table.length; i++) {
            for (int i1 = 0; i1 < table[i].length; i1++) {
                table[i][i1] = (i + 1) * (i1 + 1);
            }
        }
        return table;
    }
}
