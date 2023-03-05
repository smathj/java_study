package com.java.study.standard.ch10_format;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatEx3 {

    public static void main(String[] args) {

        SimpleDateFormat df = new SimpleDateFormat("yyyy년 MM월 dd일");
        SimpleDateFormat df2 = new SimpleDateFormat("yyyy/MM/dd");

        try {
            Date d = df.parse("2023년 3월 5일");
            System.out.println("d = " + d);
            System.out.println(df2.format(d));

        } catch(Exception e) {
            e.printStackTrace();
        }


    }
}
