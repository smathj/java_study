package com.java.study.functionInterface;

import java.util.function.ToIntFunction;

public class ToIntFunctionDemo {
    public static void main(String[] args) {
        ToIntFunction<String> f = s -> s.length();
        System.out.println(f.applyAsInt("asdasdxvxvcxvc"));
        System.out.println(f.applyAsInt("321351as3d21z3zx2c4"));
    }
}
