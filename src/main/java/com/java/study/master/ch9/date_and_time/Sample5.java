package com.java.study.master.ch9.date_and_time;

import java.time.LocalDateTime;

public class Sample5 {

    public static void main(String[] args) {

        LocalDateTime dateTime = LocalDateTime.now();

        // 3일후
        System.out.println("3일 후 :" + dateTime.plusDays(3));

        // 100일 전
        System.out.println("100일 전 :" + dateTime.minusDays(100));

        // 30초 전
        System.out.println("30초 전 :" + dateTime.minusSeconds(30));

        // 원래의 인스턴스 값
        System.out.println("원래의 값 :" + dateTime);


    }
}
