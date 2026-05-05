package com.myproject;

import java.time.Duration;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class Main {

    private final static Queue<Integer> numbers = new LinkedBlockingQueue<>(250_000);

    private static void inc(int number) {
        numbers.add(number);
    }

    private static void show() {
        System.out.println(numbers);
    }

    // Transformei em static para o main acessar
    static Runnable inc = () -> {
        for (int i = 0; i < 100; i++) {
            inc(i);
        }
    };

    static Runnable dec = () -> {
        for (int i = 0; i > -100; i--) {
            inc(i);
        }
    };

    static Runnable show = () -> {
        for (int i = 0; i < 100; i++) {
            show();
        }
    };

    public static void main(String[] args) throws InterruptedException {

        var execInc = new Thread(inc);
        execInc.start();
        execInc.setName("execInc");
        execInc.join(Duration.ofSeconds(8));

        var execDec = new Thread(dec);
        execDec.start();
        execDec.setName("execDec");

        var execShow = new Thread(show);
        execShow.start();
        execShow.setName("execShow");

        System.out.println(execInc.getName());
        System.out.println(execDec.getName());
        System.out.println(execShow.getName());
    }
}