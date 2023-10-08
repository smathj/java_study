package com.java.study.standard.cp14_stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class StreamEx2_14 {

    public static void main(String[] args) {

        String[] lineArr = {
                "Belive or not It is true",
                "Do or do not There is no try"
        };

        // ! map
        Stream<String> lineStream = Arrays.stream(lineArr);
        Stream<Stream<String>> strArrStream = lineStream.map((line) -> Stream.of(line.split(" ")));    // line.split(" +")
//        strArrStream.forEach((s) -> {
//            s.forEach(System.out::println);
//        });


//        System.out.println();


        // ! flatMap
        lineStream = Arrays.stream(lineArr);
        Stream<String> strStream = lineStream.flatMap((line) -> Stream.of(line.split(" ")));// line.split(" +")
//        strStream.forEach(System.out::println);

        strStream.map(String::toLowerCase)
                .distinct()
                .sorted()
                .forEach(System.out::println);





    }
}
