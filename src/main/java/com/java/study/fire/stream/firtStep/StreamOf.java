package com.java.study.fire.stream.firtStep;

import java.util.stream.Stream;

public class StreamOf {

    public static void main(String[] args) {
        String[] str = {"one", "two", "three"};
        Stream<String> stringStream = Stream.of(str);
        stringStream.forEach((value) -> System.out.println("value = " + value));

        System.out.println("----------------------------------------------------------------");

        Stream<String> stringStream2 = Stream.of("one", "two", "three", "four", "five");
        stringStream2.forEach((value) -> System.out.println("value = " + value));

    }
}
