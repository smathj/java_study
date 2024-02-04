package com.java.study.jdk9.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Reduce1 {

    public static void main(String[] args) {

        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        Optional<Integer> sum1 = numList.stream().reduce((x, y) -> x + y);
        Integer i = sum1.get();
        System.out.println("s1 = " + i);

        Optional<Integer> sum2 = numList.stream().reduce(Integer::sum);
        Integer i1 = sum2.get();
        System.out.println("s2 = " + i1);


    }
}
