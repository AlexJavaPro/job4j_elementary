package ru.job4j.hmap;

import java.util.*;

public class AnalyzeByMap {
    public static double averageScore(List<Pupil> pupils) {
        double subj = 0;
        int count = 0;
        if (!pupils.isEmpty()) {
            for (Pupil pupil : pupils) {
                for (Subject subject : pupil.subjects()) {
                    subj += subject.score();
                    count++;
                }
            }
        }
        return subj / count;
    }

    public static List<Label> averageScoreByPupil(List<Pupil> pupils) {
        List<Label> pupil = new ArrayList<>();
        if (pupils.isEmpty()) {
            return pupil;
        }
        for (Pupil pupil1 : pupils) {
            double score = 0;
            int count = 0;
            double averageScore;
            for (Subject subject : pupil1.subjects()) {
                score += subject.score();
                count++;
            }
            averageScore = score / count;
            pupil.add(new Label(pupil1.name(), averageScore));
        }
        return pupil;
    }

    public static List<Label> averageScoreBySubject(List<Pupil> pupils) {
        List<Label> subject = new ArrayList<>();
        if (pupils.isEmpty()) {
            return subject;
        }
        Map<String, Integer> map = new LinkedHashMap<>();
        double count = 0;
        double averageScore;
        for (Pupil pupil : pupils) {
            for (Subject subject1 : pupil.subjects()) {
                map.merge(subject1.name(), subject1.score(), Integer::sum);
            }
            count++;
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            averageScore = entry.getValue() / count;
            subject.add(new Label(entry.getKey(), averageScore));
        }
        return subject;
    }

    public static Label bestStudent(List<Pupil> pupils) {
        List<Label> labelPupil = new ArrayList<>();
        for (Pupil pupil : pupils) {
            double score = 0;
            for (Subject subject : pupil.subjects()) {
                score += subject.score();
            }
            labelPupil.add(new Label(pupil.name(), score));
        }
        labelPupil.sort(Comparator.naturalOrder());
        return labelPupil.get(labelPupil.size() - 1);
    }

    public static Label bestSubject(List<Pupil> pupils) {
        List<Label> list = new ArrayList<>();
        Map<String, Integer> map = new LinkedHashMap<>();
        for (Pupil pupil : pupils) {
            for (Subject subject : pupil.subjects()) {
                map.merge(subject.name(), subject.score(), Integer::sum);
            }
        }
        for (Map.Entry<String, Integer> mapEntry : map.entrySet()) {
            list.add(new Label(mapEntry.getKey(), mapEntry.getValue()));
        }
        list.sort(Comparator.naturalOrder());
        return list.get(list.size() - 1);
    }
}