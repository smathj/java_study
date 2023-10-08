package com.java.study.standard.cp14_stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class OptionalEx_4 {

    public static void main(String[] args) {

        IntStream stream = Arrays.stream(new int[]{1, 3, 5, 7, 10});
        boolean anyMatch = stream.anyMatch((i) -> i % 2 == 0);
        System.out.println("anyMatch = " + anyMatch);

        IntStream stream2 = Arrays.stream(new int[]{3, 1, 5, 7, 10});

        OptionalInt optionalInt = stream2.sorted()    // Comparator.reverseOrder()
                .findFirst();

        int asInt = optionalInt.getAsInt();
        System.out.println("asInt = " + asInt);


        Stream<Integer> stream3 = Arrays.stream(new Integer[]{3, 1, 5, 7, 10});
        stream3.sorted(Comparator.reverseOrder())
                .forEach(System.out::println);



    }
}
