package com.java.study.standard.ch10_date;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;

public class NewTimeEx1 {

    public static void main(String[] args) {

        LocalDate today = LocalDate.now();  // 오늘의 날짜       2023-03-07
        LocalTime now = LocalTime.now();    // 현재 시간        00:47:17.832582400

        LocalDate birthDate = LocalDate.of(1999, 12, 31);
        LocalTime birthTime = LocalTime.of(23, 59, 59);

        System.out.println("today = " + today);
        System.out.println("now = " + now);
        System.out.println("birthDate = " + birthDate);
        System.out.println("birthTime = " + birthTime);

        System.out.println(birthDate.withYear(2000));                         // 2000-12-31
        System.out.println(birthDate.plusDays(1));                  // 2001-01-01
        System.out.println(birthDate.plus(1, ChronoUnit.DAYS));   // 2001-01-01

        System.out.println(birthTime.truncatedTo(ChronoUnit.HOURS));    // 23:59:59 -> 23:00, 시간을 단위로 지정했으니 분,초는 0으로

        // 특정 ChronoField의 범위를 알아내는 방법
        System.out.println(ChronoField.CLOCK_HOUR_OF_DAY.range());  // 1 - 24
        System.out.println(ChronoField.HOUR_OF_DAY.range());  // 0 - 23


    }


}
