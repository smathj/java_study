package com.java.study.first.ch15_stream;

import java.util.stream.IntStream;

public class Test04 {

    public static void main(String[] args) {

        IntStream is = IntStream.rangeClosed(1, 100_000_000);
        long start = System.currentTimeMillis();
        int total = is.sum();
        long end = System.currentTimeMillis();
        System.out.println("순차 처리 : " + (end - start));


        IntStream is2 = IntStream.rangeClosed(1, 100_000_000).parallel();
        start = System.currentTimeMillis();
        total = is2.sum();
        end = System.currentTimeMillis();
        System.out.println("병렬 처리 : " + (end - start));


    }
}
