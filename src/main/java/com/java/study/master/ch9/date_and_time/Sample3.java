package com.java.study.master.ch9.date_and_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Sample3 {

    public static void main(String[] args) {

        System.out.println(LocalDateTime.parse("2023-01-01T23:07:15.123"));
        System.out.println(LocalDateTime.parse("2023-01-01T23:07:15"));

        System.out.println(LocalTime.parse("23:07:15.123"));
        System.out.println(LocalTime.parse("23:07:15"));

        System.out.println(LocalDate.parse("2023-01-01"));
    }
}
