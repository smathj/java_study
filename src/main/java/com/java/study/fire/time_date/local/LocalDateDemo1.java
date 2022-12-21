package com.java.study.fire.time_date.local;

import java.time.LocalDate;

public class LocalDateDemo1 {
    public static void main(String[] args) {
        // 오늘
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);


        // 올해의 크리스마스
        LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
        System.out.println("xmas = " + xmas);

        // 올해의 크리스마스 이브
        LocalDate eve = xmas.minusDays(1);
        System.out.println("eve = " + eve);

    }
}
