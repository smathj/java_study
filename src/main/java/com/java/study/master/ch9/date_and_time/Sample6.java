package com.java.study.master.ch9.date_and_time;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;

public class Sample6 {

    public static void main(String[] args) {

        TemporalAccessor parsed = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                .parse("2023-07-28 23:35:00");

        LocalDateTime dateTime = LocalDateTime.from(parsed);
        System.out.println("dateTime = " + dateTime);
    }
}
