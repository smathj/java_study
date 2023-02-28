package com.java.study.standard.ch10_date;

import java.util.Calendar;

public class Test2 {

    public static void main(String[] args) {

        Calendar today = Calendar.getInstance();
        Calendar birthDay = Calendar.getInstance();
        int year = birthDay.get(Calendar.YEAR);
        int month = birthDay.get(Calendar.MONTH) + 1;
        int date = birthDay.get(Calendar.DATE);

//        System.out.println("year = " + year);
//        System.out.println("month = " + month);
//        System.out.println("date = " + date);

        birthDay.set(year, 5, 6);

        long diffDays = Math.abs((birthDay.getTimeInMillis() - today.getTimeInMillis()) / (1000 * 60 * 60 * 24));
        System.out.println("diffDays = " + diffDays);





    }
}
