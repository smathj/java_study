package com.java.study.first.ch15_stream;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Test_Sort {

    public static void main(String[] args) {


        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("list = " + list);
        list.sort((v1,v2) -> v2 - v1);
        System.out.println("list = " + list);

        List<Integer> filterList = list.stream()
                .filter((v1) -> v1 % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("filterList = " + filterList);


    }
}
