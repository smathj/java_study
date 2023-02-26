package com.java.study.standard.ch10_date;

import java.util.Calendar;

public class CalendarEx2 {

    public static void main(String[] args) {

        final String[] DAY_OF_WEEK = {"", "일" , "월" , "화" , "수" , "목" , "금" , "토" , "일"};

        Calendar date1 = Calendar.getInstance();
        Calendar date2 = Calendar.getInstance();

        // month의 경우 0부터 시작하니까 8월이라면 숫자는 7이다
        // date1.set(2015, Calendar.AUGUST, 15);
        date1.set(2022, 7, 15); // 2015-08-15
        System.out.println("date1은 " + toString(date1) + DAY_OF_WEEK[date1.get(Calendar.DAY_OF_WEEK)] + "요일이고,");
        System.out.println("오늘(date2) " + toString(date2) + DAY_OF_WEEK[date2.get(Calendar.DAY_OF_WEEK)] + "요일입니다");

        long difference = (date2.getTimeInMillis() - date1.getTimeInMillis()) / 1000;   // 밀리초를 1000으로 나누어 초로 변환
        System.out.println("그날(date1)로 부터 지금(date2) 까지 " + difference + "초가 지났습니다");
        System.out.println("일(day)로 계산하면 " + difference / (24 * 60 * 60) + "일입니다");


    }

    public static String toString(Calendar date) {
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
    }
}
