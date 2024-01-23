package com.java.study.standard.cp11_compare.test;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTest1 {

    public static void main(String[] args) {

        Integer[] intArr = {5, 4, 3, 2, 1};

        System.out.println(Arrays.toString(intArr));
//        Arrays.sort(intArr);
//        System.out.println(Arrays.toString(intArr));
//        int compare = Integer.compare(2, 1);
//        System.out.println("compare = " + compare);

        Arrays.sort(intArr, ((p1, p2) -> p1 - p2));
//        Arrays.sort(intArr, (Comparator.comparingInt(p -> p)));
        System.out.println(Arrays.toString(intArr));

        Arrays.sort(intArr, ((p1, p2) -> p2 - p1));
        System.out.println(Arrays.toString(intArr));


        System.out.println(Integer.compare(1, 2));
        System.out.println(Integer.compare(2, 2));
        System.out.println(Integer.compare(2, 1));


        Integer[] arr2 = {1, 5, 2, 3, 5, 7, 8, 99, 1, 2095, 6, 12, 3, 4};
        System.out.println(Arrays.toString(arr2));
        Arrays.sort(arr2, Comparator.comparingInt(value -> value * -1));
        System.out.println(Arrays.toString(arr2));

    }
}
