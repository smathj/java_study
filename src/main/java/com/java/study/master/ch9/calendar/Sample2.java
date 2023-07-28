package com.java.study.master.ch9.calendar;

import java.util.Calendar;

public class Sample2 {

    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();

        // 분만 지정한다
        calendar.set(Calendar.MINUTE, 18);
        System.out.println("분의 지정: " + calendar.getTime());

        // 전부 지정 한다(월 0~11로 나타내는점 주의하자)
        calendar.set(2013, 9, 22, 18, 36, 42);  // 0 -> 1월, 9 -> 10월
        System.out.println("전부 지정: " + calendar.getTime());

        // 날짜를 표시한다
        System.out.println("날짜의 표시: " + calendar.get(Calendar.DATE));

        // 초를 표시한다
        System.out.println("초의 표시: " + calendar.get(Calendar.SECOND));

        // 연도를 2를 추가한다 (2년 후의 날짜로 변경한다)
        calendar.add(Calendar.YEAR, 2);
        System.out.println("연도 덧셈: " + calendar.getTime());

        // 월을 2 줄인다 (2달 전의 날짜로 변경한다)
        calendar.add(Calendar.MONTH, -2);
        System.out.println("월의 뺄셈: " + calendar.getTime());

        calendar.add(Calendar.MINUTE, 30);
        System.out.println("분의 덧셈: " + calendar.getTime());



    }
}
