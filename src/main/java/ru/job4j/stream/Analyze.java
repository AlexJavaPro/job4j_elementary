package ru.job4j.stream;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Analyze {
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .mapToInt(Subject::score)
                .average()
                .orElse(0D);
    }

    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .map(pupil -> {
                    return new Tuple(pupil.name(), pupil.subjects()
                            .stream()
                            .mapToInt(Subject::score)
                            .average()
                            .orElse(0D));
                })
                .collect(Collectors.toList());
    }

    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects()
                        .stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        Collectors.averagingDouble(Subject::score)
                ))
                .entrySet()
                .stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
    }

    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> {
                    return new Tuple(pupil.name(), pupil.subjects()
                            .stream()
                            .mapToDouble(Subject::score)
                            .sum());
                })
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(new Tuple(null, 0));
    }

    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.subjects().stream())
                .collect(Collectors.groupingBy(
                        Subject::name,
                        Collectors.summingDouble(Subject::score)
                ))
                .entrySet().stream()
                .map(entry -> new Tuple(entry.getKey(), entry.getValue()))
                .max(Comparator.comparingDouble(Tuple::score))
                .orElse(new Tuple(null, 0));
    }
}