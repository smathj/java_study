package com.java.study.playround;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class StringFormatTest {

    public static void main(String[] args) {


        //? %d :  정수
        //? %010d : 10자리의 정수를 표시할 거고 남는 자리는 0으로 채워 넣는다
        //? %.1f : 소수점 한자리 double,float
        //? %.2f : 소수점 두자리 double,float
        //? %.3f : 소수점 세자리 double,float
        // 예제1. 정수 값
        int intValue = 42;
        System.out.println(String.format("정수 값: %d", intValue));

        System.out.println("------------------------------------------");
        System.out.println(String.format("두자리 표시 : %02d", 2));
        System.out.println(String.format("세자리 표시 : %03d", 2));
        System.out.println(String.format("열자리 표시 : %010d", 2));
        int orderNum = 1245;
        System.out.println(String.format("바코드 번호 : %010d", orderNum));
        System.out.println("------------------------------------------");



        double doubleValue = 3.141592;
        System.out.println(String.format("소수 값(한자리): %.1f", doubleValue));
        System.out.println(String.format("소수 값(두자리): %.2f", doubleValue));
        System.out.println(String.format("소수 값(세자리): %.3f", doubleValue));

        //  빈자리 있을때 0 으로 채우기
        double dv1 = 3.1;
        System.out.println(String.format("소수 값 세자리, 나머지는 0으로 채우기 : %.3f", dv1));





        String name = "홍길동";
        System.out.println(String.format("문자열 출력: %s", name));

        LocalDate now = LocalDate.now();
        System.out.println(String.format("날짜 : %tF", now));

        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(String.format("날짜와 시간 : %tF %tT", nowTime, nowTime));


    }


}
