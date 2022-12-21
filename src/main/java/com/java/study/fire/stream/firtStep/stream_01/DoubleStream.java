package com.java.study.fire.stream.firtStep.stream_01;

import java.util.Arrays;

public class DoubleStream {
    public static void main(String[] args) {
        double[] ds = {1.1, 2.2, 3.3, 4.4, 5.5};

        Arrays.stream(ds)
                .forEach(d -> System.out.print(d + "\t"));
        System.out.println();

        Arrays.stream(ds, 1, 4) // 닫,열린 구간
                .forEach(d -> System.out.print(d + "\t"));
    }
}
