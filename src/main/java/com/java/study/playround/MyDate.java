package com.java.study.playround;

import java.util.Date;

// * Jwt 토큰에서 사용하게될 시간더하기
public class MyDate {
    public static void main(String[] args) {
//        new Date(System.currentTimeMillis() + Long.parseLong(accessTokenExpirationTime));
        System.out.println(new Date(System.currentTimeMillis()));   // 현재시각
        System.out.println(new Date(System.currentTimeMillis() + Long.parseLong("60000"))); // 현재시각 + 1 분

        System.out.println(System.currentTimeMillis()); // Long
    }
}
