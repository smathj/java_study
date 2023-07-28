package com.java.study.master.ch9.calendar;

import java.util.Calendar;

public class Sample1 {
    public static void main(String[] args) {

        Calendar calendar = Calendar.getInstance();
        System.out.println("calendar");
        System.out.println(calendar);

        System.out.println("getTime() 메서드는 Date타입을 리턴한다");
        System.out.println(calendar.getTime());


    }
}
