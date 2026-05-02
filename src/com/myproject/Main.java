package com.myproject;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Main {

    public static void main(String[] args) {
        var date = new Date();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        System.out.println(date);
        System.out.println(formatter.format(date));

        DateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
        System.out.println(formatter2.format(date));

        DateFormat formatter3 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        System.out.println(formatter3.format(date));

        var milliseconds = System.currentTimeMillis();
        var date2 = new Date(milliseconds);
        System.out.println(date2.getTimezoneOffset() / 60);
    }

}