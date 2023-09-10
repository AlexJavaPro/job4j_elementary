package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        Map<String, String> hashMaps = new HashMap<>();
        hashMaps.put("iiivanov@job4j.ru", "Ivanov Ivan Ivanovich");
        for (String key : hashMaps.keySet()) {
            System.out.println(key + " = " + hashMaps.get(key));
        }
    }
}