package com.java.study.standard.cp14_stream;

import java.util.Random;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;

public class StreamEx2_2 {

    public static void main(String[] args) {

        IntStream r1 = new Random().ints();
        r1.limit(5).forEach((i) -> System.out.print(i + " "));

        System.out.println();

        IntStream r2 = new Random().ints(10);
        r2.forEach((i) -> System.out.print(i + " "));


        System.out.println();

        DoubleStream r3 = new Random().doubles(10);
        r3.forEach((i) -> {
            int abs = (int)Math.abs(i * 10);
            System.out.print(abs + " ");
        });

        System.out.println();



    }
}
