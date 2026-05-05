package com.myproject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Integer> numbers = new ArrayList<>();

    private synchronized static void inc(int number) {
        numbers.add(number);
    }

    private synchronized static void show() {
        System.out.println(numbers);
    }

    // Transformei em static para o main acessar
    static Runnable inc = () -> {
        for (int i = 0; i < 100_000; i++) {
            inc(i);
        }
    };

    static Runnable dec = () -> {
        for (int i = 100_000; i > 0; i--) {
            inc(i);
        }
    };

    static Runnable show = () -> {
        for (int i = 0; i < 250_000; i++) {
            show();
        }
    };

    public static void main(String[] args) {
        new Thread(inc).start();
        new Thread(dec).start();
        new Thread(show).start();
    }
}