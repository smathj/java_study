package com.java.study.practical.ch6_parallel.part4_fork_join;

import java.util.Arrays;
import java.util.List;

public class ParallelReduceMinMax {

    public static void main(String[] args) {

        List<Integer> intList = Arrays.asList(4, 2, 8, 1, 9, 6, 7, 3, 5);

        // 최댓값 구하기 - 병렬
        int max = intList.parallelStream().reduce(1, Integer::sum);
        System.out.println("max = " + max);

        // 최솟값 구하기 - 병렬
        int min = intList.parallelStream().reduce(1, Integer::min);
        System.out.println("min = " + min);


    }
}
