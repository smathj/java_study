package com.java.study.standard.cp14_stream;

import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx2_11 {

    public static void main(String[] args) {

        IntStream intStream = new Random().ints(1, 46);

        Stream<String> lottoStream = intStream
                .distinct()
                .limit(6)
                .sorted()
                .mapToObj((i) -> i + " ");// 문자열로 변환    Stream<U> 반환

        lottoStream.forEach(System.out::print);

    }
}
