package com.java.study.standard.cp14_stream;

import java.util.stream.IntStream;

public class StreamEx2_5 {

    public static void main(String[] args) {

        // 중복제거 , 필터링
        IntStream intStream = IntStream.of(1, 2, 3, 4, 5, 1, 2, 3, 3, 3, 6, 7, 9, 5);
        intStream.distinct()
                .filter((i) -> i % 2 == 0)
                .filter((i) -> i > 2)
                .forEach((i) -> System.out.print(i + " "));



    }
}
