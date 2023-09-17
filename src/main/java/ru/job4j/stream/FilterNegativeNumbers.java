package ru.job4j.stream;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class FilterNegativeNumbers {

    public static void main(String[] args) {
        List<Integer> numbers = Stream.generate(() -> new Random().nextInt(-20, 20)).limit(10).toList();
        List<Integer> positive = numbers.stream().filter(number -> number > 0).collect(toList());
        positive.forEach(System.out::println);
    }
}