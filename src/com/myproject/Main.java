package com.myproject;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Main {
    public static void main(String[] args) {

        var value1 = 0.1;
        var value2 = 0.2;

        System.out.println(value1 + value2);

        System.out.println("=====================================");

        System.out.println(2.00 - 1.1);
        System.out.println(2.00 - 1.2);
        System.out.println(2.00 - 1.3);
        System.out.println(2.00 - 1.4);
        System.out.println(2.00 - 1.5);
        System.out.println(2.00 - 1.6);
        System.out.println(2.00 - 1.7);
        System.out.println(2.00 - 1.8);
        System.out.println(2.00 - 1.9);

        System.out.println("=====================================");

        var value3 = new BigDecimal(String.valueOf(value1));
        var value4 = new BigDecimal(String.valueOf(value2));

        System.out.println(value3.add(value4));

        System.out.println("=====================================");

        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.1")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.2")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.3")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.4")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.5")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.6")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.7")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.8")));
        System.out.println(new BigDecimal("2.00").subtract(new BigDecimal("1.9")));

        System.out.println("=====================================");

        var value5 = new BigDecimal("56.3645");
        var value6 = new BigDecimal("99.345");
        System.out.println(value5.multiply(value6));

        System.out.println("=====================================");

        var value7 = new BigDecimal("56.3678");
        var value8 = new BigDecimal("99.34");
        System.out.println(value8.divide(value7, 3, RoundingMode.HALF_UP));

        System.out.println("=====================================");

        System.out.println(value8.negate());
        System.out.println(value8.abs());
        System.out.println(value8.intValue());
        System.out.println(value8.doubleValue());

        System.out.println("=====================================");

        var value9 = new BigDecimal("144");
        System.out.println(value9.sqrt(new MathContext(2)));
        var value10 = new BigDecimal("4");
        System.out.println(value10.pow(2));

        System.out.println("=====================================");
    }

}
