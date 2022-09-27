package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        String s = "jjfkhaks2387HODGejgtfai";

        System.out.println(caracterRepetit(s));
        System.out.println(caracterNoRepetit(s));
    }

    public static char caracterRepetit(String s) {
        //Mètode 1

        //Inicialitzem
        Set<Integer> intMap = new HashSet<>();
        //Filtrem els caràcters repetits (el Set no pot tenir repeticions) i obtenim el primer que no s'ha pogut afegir
        System.out.println((char) s.chars().filter(character -> !intMap.add(character)).findFirst().orElse(0));

        //Mètode 2

        //Inicialitzem
        Set<Character> map = new HashSet<>();

        //Recorrem el string
        for (int i = 0; i < s.length(); i++) {
            //Obtenim el caràcter actual
            char current = s.charAt(i);
            //Si el mapa ja conté el caràcter actual
            if (map.contains(current)) {
                //Retornem
                return current;
            } else {
                //Si no, l'afegim al mapa
                map.add(current);
            }
        }
        //Retornem caràcter buit
        return '\0';
    }

    public static char caracterNoRepetit(String s) {
        //Inicialitzem
        Map<Character, Integer> map = new LinkedHashMap<>();

        //Recorrem el string
        for (int i = 0; i < s.length(); i++) {
            //Caràcter actual
            char current = s.charAt(i);
            //Comprovem si el caràcter ja existeix al set; si ho fa, incrementem el seu compte
            map.put(current, map.containsKey(current) ? map.get(current) + 1 : 1);
        }
        //Trobem el primer caràcter que apareix només una vegada al string i el retornem; si no, caràcter buit
        return map.entrySet().stream()
                .filter(element -> element.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse('\0');
    }
}