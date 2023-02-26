package com.java.study.standard.ch10_date;

import java.util.Calendar;

public class CalendarEx5 {

    public static void main(String[] args) {

        Calendar date = Calendar.getInstance();
        date.set(2015, 0, 31);  // 2015 01 31
        System.out.println(toString(date));

        date.roll(Calendar.MONTH, 1);   // 말일 일경우 월이 오른다
        System.out.println(toString(date));
    }


    public static String toString(Calendar date) {
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
    }
}
