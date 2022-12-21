package com.java.study.modern.rest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> sum = new ArrayList<>();
        sum.addAll(list);
        sum.remove(0);
        System.out.println();

        Test.make(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    }

    public static <T> void make(T... wordList) {
        System.out.println("type : " + wordList.getClass().getSimpleName());
        for (T t : wordList) {
            System.out.println("value = " + t + ", type : " + t.getClass().getSimpleName());
        }
    }

}
