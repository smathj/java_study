package com.java.study.fire.time_date.format;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeFormatterDemo {
    public static void main(String[] args) {
//        ZonedDateTime date = ZonedDateTime.of(
//                LocalDateTime.of(2019, 4, 25, 11, 20),
//                ZoneId.of("Asia/Seoul")
//        );

        ZonedDateTime date = ZonedDateTime.of(
                LocalDateTime.now(),
                ZoneId.of("Asia/Seoul")
        );

        DateTimeFormatter fm1 = DateTimeFormatter.ofPattern("yy-M-d");
        DateTimeFormatter fm2 = DateTimeFormatter.ofPattern("yyyy-MM-d, H:m:s");
        DateTimeFormatter fm3 = DateTimeFormatter.ofPattern("yyyy-MM-dd, HH:mm:ss VV");

        System.out.println(date.format(fm1));
        System.out.println(date.format(fm2));
        System.out.println(date.format(fm3));


        // LocalDateTime 사용
        System.out.println();
        LocalDateTime today = LocalDateTime.now();
        String format1 = today.format(fm1);
        String format2 = today.format(fm2);
        System.out.println("format1 = " + format1);
        System.out.println("format2 = " + format2);


    }
}
