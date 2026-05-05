package com.myproject;

import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    private static AtomicInteger number = new AtomicInteger(0);

    static Runnable inc = () -> {
        for (int i = 0; i < 1_000_000; i++) {
            number.incrementAndGet();
        }
        System.out.println("Thread INC finalizada!");
    };

    static Runnable dec = () -> {
        for (int i = 0; i < 1_000_000; i++) {
            number.decrementAndGet();
        }
        System.out.println("Thread DEC finalizada!");
    };

    static Runnable show = () -> {
        // Mostra o progresso a cada 100ms enquanto as outras threads
        // estiverem vivas (opcional) ou por um tempo
        for (int i = 0; i < 10; i++) {
            try {
                System.out.println("Valor atual monitorado: " + number.get());
                Thread.sleep(100);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    };

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(inc);
        Thread t2 = new Thread(dec);
        Thread t3 = new Thread(show);

        t1.start();
        t2.start();
        t3.start();

        // Faz o programa principal esperar as threads de cálculo terminarem
        t1.join();
        t2.join();

        System.out.println("---------------------------------");
        System.out.println("RESULTADO FINAL (Esperado 0): " + number.get());
        System.out.println("---------------------------------");
    }
}