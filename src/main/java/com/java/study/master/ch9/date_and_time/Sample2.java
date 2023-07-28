package com.java.study.master.ch9.date_and_time;

import java.time.LocalDateTime;
import java.time.Month;

public class Sample2 {

    public static void main(String[] args) {


        System.out.println(LocalDateTime.of(2017, Month.JANUARY, 1, 1, 23, 45));

        System.out.println(LocalDateTime.of(2017, 1, 1, 1, 23, 45, 678_000_000));



    }
}
