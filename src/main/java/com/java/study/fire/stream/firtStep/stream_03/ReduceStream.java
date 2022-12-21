package com.java.study.fire.stream.firtStep.stream_03;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class ReduceStream {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Box", "Simple", "Complex", "Robot");

        BinaryOperator<String> lc = (s1, s2) -> {
            if (s1.length() > s2.length()) {
                return s1;
            } else {
                return s2;
            }
        };
        String str = ls.stream()
                .reduce("", lc);    // 스트림이 빈경우 빈문자열 반환
        System.out.println(str);
    }
}
