package com.myproject;

import java.util.Calendar;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.ZoneOffset;

public class Main {

    public static void main(String[] args) {

        LocalDate localDate = LocalDate.now();
        LocalTime localtime = LocalTime.now();
        LocalDateTime localDateTime = localDate.atTime(localtime);
        OffsetDateTime offsetDateTime = OffsetDateTime.now();

        System.out.println("1- " + offsetDateTime);

        OffsetDateTime offsetDateTimeUTC = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC);

        System.out.println("2- " + offsetDateTimeUTC);

        offsetDateTime = offsetDateTime.withOffsetSameInstant(ZoneOffset.UTC);

        System.out.println("3- " + offsetDateTime);
        System.out.println("4- " + offsetDateTime.getOffset());
        System.out.println("5- " + offsetDateTime.isEqual(offsetDateTimeUTC));

        DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
        System.out.println("6- " + formatter.format(localDateTime));

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        ZoneId zoneId = calendar.getTimeZone().toZoneId();
        LocalDateTime localDateTime2 = localDateTime.ofInstant(calendar.toInstant(), zoneId);
        System.out.println("7- " + localDateTime2);

        System.out.println("8- " + Duration.between(localDateTime, localDateTime.now()).toMillis());

        System.out.println("9- " + localDateTime.toInstant(ZoneOffset.ofHours(-3)));

        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("hh:mm:ss");
        System.out.println("10- " + timeFormatter.format(localtime));

        System.out.println("11- " + localDate);
        System.out.println("12- " + localtime);
        System.out.println("13- " + localDate.plus(50, ChronoUnit.DAYS));
        System.out.println("14- " + localDate.plusYears(20));
        System.out.println("15- " + localDate.minusYears(20));
        System.out.println("16- " + localDate.getMonth());
        System.out.println("17- " + localDate.getMonthValue());

        var strDate = "22/12/2015";
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.println("18- " + LocalDate.parse(strDate, dateFormatter));
        System.out.println("19- " + dateFormatter.format(LocalDate.parse(strDate, dateFormatter)));

        var date2 = Date.from(offsetDateTime.toInstant());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date2);
        System.out.println("20- " + calendar2.getTime());

        date = calendar.getTime();
        OffsetDateTime offsetDateTime2 = date.toInstant().atOffset(ZoneOffset.ofHours(-3));
        System.out.println("21- " + offsetDateTime2);

    }

}