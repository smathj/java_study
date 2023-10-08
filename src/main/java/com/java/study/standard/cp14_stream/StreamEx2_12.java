package com.java.study.standard.cp14_stream;

import java.util.stream.IntStream;

public class StreamEx2_12 {

    public static void main(String[] args) {

        IntStream charStream = "12345".chars();
        int sum = charStream.map(ch -> {
//            System.out.println("ch = " + ch);
            int i = ch - '0';   // x - 48
//            System.out.println("i = " + i);
//            System.out.println();
            return i;
        }).sum();
        System.out.println("sum = " + sum);

    }
}
