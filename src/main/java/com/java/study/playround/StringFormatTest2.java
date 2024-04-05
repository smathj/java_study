package com.java.study.playround;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StringFormatTest2 {

    public static void main(String[] args) {

        // 예제: 정수 및 소수 값 포맷팅 (빈 자리 0으로 채우기)
        double doubleValue = 3.14159;
        // 사용하는 형식: %02.3f (최소 2 자리 정수 + 소수점 + 3 자리 소수)
        String formattedDouble = String.format("값: %02.3f", doubleValue);
        System.out.println(formattedDouble); // 출력: 값: 03.142
    }


}
