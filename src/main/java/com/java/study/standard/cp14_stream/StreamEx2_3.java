package com.java.study.standard.cp14_stream;

import java.util.stream.Stream;

public class StreamEx2_3 {

    public static void main(String[] args) {

        Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        iterate.limit(5).forEach((i) -> System.out.print(i + " "));

        System.out.println();

        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(5).forEach((i) -> System.out.print(i + " "));


    }
}
