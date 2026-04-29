package com.myproject;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

        var value1 = Stream.of("Maria", "João", "Pedro", "Ana", "Lucas", "Luana", "Marcia", "Leandro")
                .filter(name -> name.endsWith("o"))
                .limit(2)
                .toList();
        System.out.println(value1);

        System.out.println("\n------------------------------------------\n");

        var value2 = Stream.of("Maria", "João", "Pedro", "Ana", "Lucas", "Luana", "Marcia")
                .filter(n -> n.endsWith("o"))
                .anyMatch(n -> n.contains("J"));
        System.out.println(value2);

        System.out.println("\n------------------------------------------\n");

        var value3 = Stream.of("Maria", "João", "Pedro", "Ana", "Lucas", "Luana", "Marcia", "Leandro")
                .reduce("", (a, b) -> a + b + ";");
        System.out.println(value3);

        System.out.println("\n------------------------------------------\n");

        var value4 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 7, 8, 7)
                .distinct().toList();

        System.out.println(value4);

        System.out.println("\n------------------------------------------\n");

        var value5 = Stream.of(1, 2, 3, 4, 5, 6, 7, 8)
                .map(n -> n % 2 == 0)
                .toList();

        System.out.println(value5);

        System.out.println("\n------------------------------------------\n");

        List<Integer> values6 = List.of(3, 6, 9, 12);
        List<Integer> values7 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12);

        var newValues = values7.stream()
                .filter(values6::contains)
                .peek(n -> System.out.printf("Filter %s \n", n))
                .map(n -> values6.stream().reduce(n, (n1, n2) -> n1 - n2))
                .peek(n -> System.out.printf("Map %s \n", n))
                .collect(Collectors.toSet());

        System.out.println(newValues);

        System.out.println("\n------------------------------------------\n");
    }

}