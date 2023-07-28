package com.java.study.master.ch9.date_and_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Sample7 {

    public static void main(String[] args) {

        TemporalAccessor parsed = DateTimeFormatter.ISO_LOCAL_DATE_TIME.parse("2023-07-28T23:38:10");
        LocalDateTime dateTime = LocalDateTime.from(parsed);
        System.out.println("dateTime = " + dateTime);

    }
}
