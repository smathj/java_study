package com.java.study.fire.time_date.zone;

import java.time.ZoneId;

public class ZoneIdDemo1 {
    public static void main(String[] args) {
        ZoneId paris = ZoneId.of("Europe/Paris");
        System.out.println(paris);
    }
}
