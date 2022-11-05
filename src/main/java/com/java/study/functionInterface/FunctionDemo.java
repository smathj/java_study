package com.java.study.functionInterface;

import java.util.function.Function;

public class FunctionDemo {
    public static void main(String[] args) {
        //      파라미터타입, 리턴타입
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("가나다"));
        System.out.println(f.apply("13205461324"));
    }
}
