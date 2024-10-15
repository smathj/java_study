package com.java.study.first.ch15_stream;

import java.util.ArrayList;
import java.util.Optional;

public class Test06 {

    public static void main(String[] args) {

        ArrayList<Double> list = new ArrayList<>();

        list.add(3.1);
        list.add(5.6);
        list.add(7.2);
        list.add(8.1);
        list.add(6.8);

        System.out.println("계산 1 : ");
        Optional<Integer> sumValue = list.stream()
                .map((n) -> (int) Math.ceil(n))
                .reduce((a, b) -> a + b);
        System.out.println(sumValue.get());


        System.out.println("계산 2 : ");
        int sum = list.stream()
                .mapToInt((n) -> (int) Math.ceil(n))
                .sum();
        System.out.println(sum);

    }
}
