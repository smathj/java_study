package com.java.study.stream.stream_01;

import java.util.Arrays;

public class StringStream2 {
    public static void main(String[] args) {
        String[] names = {"K", "O", "R"};
        Arrays.stream(names)
                .forEach(s -> System.out.println(s));    // 최종 연산 진행
    }
}
