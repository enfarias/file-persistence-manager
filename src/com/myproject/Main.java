package com.myproject;

import java.time.Duration;
import java.time.OffsetDateTime;

public class Main {
    public static void main(String[] args) {

        var stringStart = OffsetDateTime.now();

        String stringConcat = "";
        for (int i = 0; i < 400_000; i++) {
            stringConcat += i;
        }

        var stringEnd = OffsetDateTime.now();
        System.out.printf("String: %s \n", getInterval(stringStart, stringEnd));

        var builderStart = OffsetDateTime.now();
        var builderConcat = new StringBuilder();
        for (int i = 0; i < 400_000; i++) {
            builderConcat.append(i);
        }

        var builderEnd = OffsetDateTime.now();
        System.out.printf("StringBuilder (singlethread): %s \n", getInterval(builderStart, builderEnd));

        var bufferStart = OffsetDateTime.now();
        var bufferConcat = new StringBuffer();
        for (int i = 0; i < 400_000; i++) {
            bufferConcat.append(i);
        }

        var bufferEnd = OffsetDateTime.now();
        System.out.printf("StringBuffer (multithread): %s \n", getInterval(bufferStart, bufferEnd));
    }

    private static long getInterval(final OffsetDateTime springStart, final OffsetDateTime springEnd) {
        return Duration.between(springStart, springEnd).toMillis();
    }

}
