package com.java.study.master.ch9.date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Sample1 {

    public static void main(String[] args) {

        // 날짜
        LocalDate date = LocalDate.now();
        System.out.println("date = " + date);

        // 시각
        LocalTime time = LocalTime.now();
        System.out.println("time = " + time);

        // 일시
        LocalDateTime dateTime = LocalDateTime.now();
        System.out.println("dateTime = " + dateTime);

    }
}
