package com.java.study.stream.firtStep;

import java.util.stream.IntStream;


// 범위
public class StreamRange {

    public static void main(String[] args) {

        System.out.println("IntStream.rage 실행합니다");
        IntStream intStream = IntStream.range(1, 5);
        intStream.forEach((value -> System.out.println("value = " + value)));

        System.out.println("-----------------------------------------------------------");

        System.out.println("IntStream.rageClosed 실행합니다");
        IntStream intStreamClose = IntStream.rangeClosed(1, 5);
        intStreamClose.forEach((value -> System.out.println("value = " + value)));
    }

}
