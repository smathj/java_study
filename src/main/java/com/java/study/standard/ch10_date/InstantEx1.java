package com.java.study.standard.ch10_date;

import java.time.Instant;
import java.util.Date;

public class InstantEx1 {

    public static void main(String[] args) {


        Instant now = Instant.now();
        System.out.println("now = " + now);

        int nano = now.getNano();
        System.out.println("nano = " + nano);

        long epochSecond = now.getEpochSecond();
        System.out.println("epochSecond = " + epochSecond);

        long l = now.toEpochMilli();
        System.out.println("l = " + l);

        Date from = Date.from(now);
        System.out.println("from = " + from);

        Instant instant = from.toInstant();
        System.out.println("instant = " + instant);
    }
}
