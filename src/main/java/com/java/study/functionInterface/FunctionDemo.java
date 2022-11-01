package com.java.study.functionInterface;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("가나다"));
        System.out.println(f.apply("13205461324"));
    }
}
