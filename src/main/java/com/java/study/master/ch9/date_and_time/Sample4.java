package com.java.study.master.ch9.date_and_time;

import java.time.LocalDateTime;
import java.time.Month;

public class Sample4 {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();

        int year = dateTime.getYear();
        System.out.println("year = " + year);

        Month month = dateTime.getMonth();
        System.out.println("month = " + month);

        int monthValue = dateTime.getMonthValue();
        System.out.println("monthValue = " + monthValue);

        int dayOfMonth = dateTime.getDayOfMonth();
        System.out.println("dayOfMonth = " + dayOfMonth);

        int hour = dateTime.getHour();
        System.out.println("hour = " + hour);


        int minute = dateTime.getMinute();
        System.out.println("minute = " + minute);

        int second = dateTime.getSecond();
        System.out.println("second = " + second);

        int nano = dateTime.getNano();
        System.out.println("nano = " + nano);


    }
}
