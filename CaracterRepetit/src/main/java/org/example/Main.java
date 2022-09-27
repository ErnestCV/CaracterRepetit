package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String s = "jjfkhaks2387HODGejgtfai";

        System.out.println(caracterRepetit(s));
        System.out.println(caracterNoRepetit(s));
    }

    public static String caracterRepetit(String s) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            if (map.containsKey(current)) {
                return current;
            } else {
                map.put(current, 1);
            }
        }
        return "N/A";
    }

    public static String caracterNoRepetit(String s) {
        Map<String, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            String current = String.valueOf(s.charAt(i));
            Integer count = map.getOrDefault(current, 1);
            if (map.containsKey(current)) {
                map.put(current, count + 1);
            } else {
                map.put(current, count);
            }
        }
        return map.entrySet().stream()
                .filter(element -> element.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse("N/A");
    }
}