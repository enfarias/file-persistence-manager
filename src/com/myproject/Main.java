package com.myproject;

public class Main {

    public static void main(String[] args) {

        Clock brlClock = new BRLClock();

        brlClock.setHour(25);
        brlClock.setMinute(5);
        brlClock.setSecond(45);

        System.out.println("BRL Clock: " + brlClock.getTime());

        System.out.println("US Clock: " + new USClock().convert(brlClock).getTime());
    }

}
