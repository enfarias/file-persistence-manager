package com.myproject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws ParseException {
        var calendar = Calendar.getInstance();
        DateFormat formatter = new SimpleDateFormat("dd/MM/yyy HH:mm:ss Z");
        System.out.println(formatter.format(calendar.getTime()));

        System.out.println("================================");

        System.out.println("Year: " + calendar.get(Calendar.YEAR));
        System.out.println("Month: " + calendar.get(Calendar.MONTH));
        System.out.println("Date: " + calendar.get(Calendar.DATE));
        System.out.println("Day of month: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println("Day of year: " + calendar.get(Calendar.DAY_OF_YEAR));
        System.out.println("day of week: " + calendar.get(Calendar.DAY_OF_WEEK));
        System.out.println("hour: " + calendar.get(Calendar.HOUR));
        System.out.println("hour of day: " + calendar.get(Calendar.HOUR_OF_DAY));
        System.out.println("minute: " + calendar.get(Calendar.MINUTE));
        System.out.println("second: " + calendar.get(Calendar.SECOND));
        System.out.println("millisecond: " + calendar.get(Calendar.MILLISECOND));
        System.out.println("Zone offset: " + calendar.get(Calendar.ZONE_OFFSET));
        System.out.println("DST offset: " + calendar.get(Calendar.DST_OFFSET));
        System.out.println("AM_PM: " + calendar.get(Calendar.AM_PM));

        System.out.println("================================");

        Date date = calendar.getTime();
        calendar.setTime(date);
        System.out.println(formatter.format(calendar.getTime()));

        System.out.println("================================");

        calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 5);
        System.out.println(formatter.format(calendar.getTime()));

        System.out.println("================================");

        var newCallendar = Calendar.getInstance();
        newCallendar.set(Calendar.HOUR, calendar.get(Calendar.HOUR) + 1);
        System.out.println(calendar.before(newCallendar));
        System.out.println(calendar.equals(newCallendar));

        System.out.println("================================");

        var stringDate = formatter.format(calendar.getTime());
        stringDate = stringDate.replace("18:", "21:");
        var newData = formatter.parse(stringDate);
        var newCalendar = Calendar.getInstance();
        newCalendar.setTime(newData);
        System.out.println(formatter.format(calendar.getTime()));
        System.out.println(formatter.format(newCalendar.getTime()));

        System.out.println("================================");

    }
}