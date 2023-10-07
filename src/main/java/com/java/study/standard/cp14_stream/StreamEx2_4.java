package com.java.study.standard.cp14_stream;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx2_4 {

    public static void main(String[] args) {

        Stream<Object> empty = Stream.empty();
        long count = empty.count();
        System.out.println("count = " + count);


        // boxed() : IntStream -> Stream<Integer>
        Stream<Integer> s1 = IntStream.rangeClosed(1, 5).boxed();
        Stream<Integer> s2 = IntStream.rangeClosed(1, 6).boxed();

        // 중복을 포함한다
        Stream<Integer> concat = Stream.concat(s1, s2);
        concat.forEach((i) -> System.out.print(i + " "));

        System.out.println();

        // 스트림 자르기, 갯수제한
        Stream<Integer> s3 = IntStream.rangeClosed(1, 5).boxed();
        Stream<Integer> s4 = IntStream.rangeClosed(1, 6).boxed();
        Stream<Integer> concat2 = Stream.concat(s3, s4);
        // 12345123456 -> 123456 -> 123
        concat2.skip(5).limit(3).forEach((i) -> System.out.print(i + " "));




    }
}
