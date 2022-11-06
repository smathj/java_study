package com.java.study.time_date.local;

import java.time.Duration;
import java.time.LocalTime;

public class LocalTimeDemo2 {
    public static void main(String[] args) {

        // PC방의 PC 이용 시작 시간
        LocalTime start = LocalTime.of(14, 24, 35); // 시 분 초
        System.out.println("PC 이용 시작 시각 : " + start);

        // PC방의 PC 이용 종료 시각
        LocalTime end = LocalTime.of(17,31, 19);
        System.out.println("PC 이용 종료 시각 : " + end);

        // PC 이용 시간 계산
        Duration between = Duration.between(start, end);
        System.out.println("총 PC 이용 시간" + between);

    }
}
