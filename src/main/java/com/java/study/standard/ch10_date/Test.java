package com.java.study.standard.ch10_date;

import java.util.Calendar;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        Calendar today = Calendar.getInstance();


        int b = today.get(Calendar.DATE);
        System.out.println("b = " + b);


        // 1. Calendar -> Date
        Date nowDate = new Date(today.getTimeInMillis());

        // 2. Date -> Calendar
        Calendar newCalendar = Calendar.getInstance();
        newCalendar.setTime(nowDate);


        int actualMaximum = newCalendar.getActualMaximum(Calendar.DATE);
        System.out.println("actualMaximum = " + actualMaximum); // 28


        newCalendar.add(Calendar.DATE, 1);

        int monthNum = newCalendar.get(Calendar.MONTH);
        System.out.println("monthNum = " + (monthNum + 1) + "월 입니다");


        boolean isAfter = newCalendar.after(today);
        System.out.println("isAfter = " + isAfter);


        // 오늘날짜 칼렌더 2개 인스턴스 생성
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();

        boolean c1c2 = c1.after(c2);
        boolean c2c1 = c2.after(c1);
        System.out.println("c1c2 = " + c1c2);
        System.out.println("c2c1 = " + c2c1);


    }
}
