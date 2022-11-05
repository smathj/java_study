package com.java.study.stream.stream_01;

import java.util.Arrays;
import java.util.stream.IntStream;

public class MyFirstStream {
    public static void main(String[] args) {
        int[] ar = {1, 2, 3, 4, 5};
        IntStream stm1 = Arrays.stream(ar); // 배열 ar로 부터 스트림 생성
        IntStream stm2 = stm1.filter(n -> n % 2 == 1);  // 중간연산 진행
        int sum = stm2.sum();   // 최종연산 진행
        System.out.println(sum);

    }

}
