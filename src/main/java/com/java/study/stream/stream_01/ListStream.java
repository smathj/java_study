package com.java.study.stream.stream_01;

import java.util.Arrays;
import java.util.List;

public class ListStream {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("K", "O", "R");
        list.stream()
                .forEach(s -> System.out.print(s + "\t"));
        System.out.println();
    }
}
