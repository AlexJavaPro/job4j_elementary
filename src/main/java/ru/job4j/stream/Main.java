package ru.job4j.stream;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(values -> new Card(suit, values)))
                .forEach(System.out::println);
    }
}
