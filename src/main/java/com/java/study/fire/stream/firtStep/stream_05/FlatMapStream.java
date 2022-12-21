package com.java.study.fire.stream.firtStep.stream_05;

import java.util.Arrays;
import java.util.stream.Stream;

public class FlatMapStream {
    public static void main(String[] args) {
        Stream<String> ss1 = Stream.of("MY_AGE", "YOUR_LIFE");

        // 아래 람다식에서 스트림을 생성
        Stream<String> ss2 = ss1.flatMap(s -> Arrays.stream(s.split("_")));
        ss2.forEach(s -> System.out.print(s + "\t"));
        System.out.println();
    }
}
