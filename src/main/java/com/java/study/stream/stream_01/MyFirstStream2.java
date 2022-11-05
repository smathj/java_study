package com.java.study.stream.stream_01;

import java.util.Arrays;

public class MyFirstStream2 {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};

        int sum = Arrays.stream(ar) // 스트림 생성
                .filter(n -> n % 2 == 1) // filter 통과시킴
                .sum(); // sum을 통과시켜 그 결과를 반환한다
        System.out.println("sum = " + sum);
    }
}
