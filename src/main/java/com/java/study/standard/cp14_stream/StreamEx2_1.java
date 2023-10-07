package com.java.study.standard.cp14_stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEx2_1 {

    public static void main(String[] args) {

        Stream<Integer> s1 = Stream.of(1);
        s1.forEach((i) -> System.out.print(i + " "));

        System.out.println();

        Stream<Integer> s2 = Stream.of(1, 2);
        s2.forEach((i) -> System.out.print(i + " "));

        System.out.println();

        IntStream i1 = Arrays.stream(new int[]{1, 2, 3});
        i1.forEach((i) -> System.out.print(i + " "));

        System.out.println();

        IntStream i2 = IntStream.of(1, 2, 3, 4, 5, 6);
        i2.forEach((i) -> System.out.print(i + " "));

        System.out.println();

        IntStream i3 = IntStream.range(1, 5);
        i3.forEach((i) -> System.out.print(i + " "));

        System.out.println();

        IntStream i4 = IntStream.rangeClosed(1, 5);
        i4.forEach((i) -> System.out.print(i + " "));

        System.out.println();


    }
}
