package com.java.study.standard.ch10_date;

import java.util.Calendar;

public class CalendarEx4 {

    public static void main(String[] args) {


        Calendar date = Calendar.getInstance();
        date.set(2022, 7, 31);  // 2022.08.31

        System.out.println(toString(date));
        System.out.println("= 1일 후 =");

        date.add(Calendar.DATE, 1);
        System.out.println(toString(date));

        System.out.println("= 6달 전 =");
        date.add(Calendar.MONTH, -6);

        System.out.println("= 31일 후(roll) =");
        date.roll(Calendar.DATE, 31);   // 월에 영향을 주지 않는다
        System.out.println(toString(date));


        System.out.println("= 31일 후(add) =");
        date.add(Calendar.DATE, 31);    // 월에 영향을 준다
        System.out.println(toString(date));


    }


    public static String toString(Calendar date) {
        return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일 ";
    }
}
