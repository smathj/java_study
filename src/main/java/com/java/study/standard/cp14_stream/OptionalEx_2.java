package com.java.study.standard.cp14_stream;

import java.util.Optional;

public class OptionalEx_2 {

    public static void main(String[] args) {

        int result = Optional.of("123")
                .filter((s) -> s.length() > 0)
                .map((s) -> Integer.parseInt(s))
                .orElse(-1);    // null이면 -1 리턴

        System.out.println("result = " + result);

        result = Optional.of("")
                        .filter((s) -> s.length() > 0)
                        .map((s) -> Integer.parseInt(s))
                        .orElse(-1);    // null이면 -1 리턴

        System.out.println("result = " + result);

    }
}
