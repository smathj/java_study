package com.java.study.time_date.local;

import java.time.LocalDate;
import java.time.Period;

public class LocalDateDemo2 {
    public static void main(String[] args) {
        
        // 오늘
        LocalDate today = LocalDate.now();
        System.out.println("today = " + today);


        // 올해의 크리스마스
        LocalDate xmas = LocalDate.of(today.getYear(), 12, 25);
        System.out.println("xmas = " + xmas);
        
        // 크리스마스까지 앞으로 며칠?
        Period left = Period.between(today, xmas);
        System.out.println("크리스마스 까지 앞으로 " + left.getMonths() + "월" + left.getDays() + "일");
    }
    
}
