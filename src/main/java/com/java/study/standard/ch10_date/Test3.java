package com.java.study.standard.ch10_date;

import java.util.Calendar;

public class Test3 {

    public static void main(String[] args) {

        Calendar today = Calendar.getInstance();
        int i = today.get(Calendar.DAY_OF_WEEK);
        System.out.println("i = " + i); // 일,월,화 <- 화요일이니 3 ?
//  일 1 , 월 2, 화 3, 수 4, 목 5, 금 6, 토 7

        int date = today.get(Calendar.DATE);
        System.out.println("date = " + date);   // 3월 7일 (7일)

    }

}
