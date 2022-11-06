package com.java.study.stream.stream_06;

import java.util.stream.IntStream;

public class MatchStream {
    public static void main(String[] args) {
        boolean b = IntStream.of(1, 2, 3, 4, 5)
                .allMatch(n -> n % 2 == 0);
        System.out.println("모두 짝수인가요? :" + b);


        b = IntStream.of(1, 2, 3, 4, 5)
                .anyMatch(n -> n % 2 == 0);
        System.out.println("최소 한개이상의 짝수가 존재하나요? : " + b);


        b = IntStream.of(1, 2, 3, 4, 5)
                .noneMatch(n -> n % 2 == 0);
        System.out.println("짝수가 단하나도 없나요? : " + b);
    }
}
