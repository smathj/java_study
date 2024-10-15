package com.java.study.lamda.ch3.scope;

import java.util.function.Supplier;

public class Example {

    int i = 5;

    public Integer example() {
        Supplier<Integer> function = () -> i * 2;
        Integer v = function.get();
        System.out.println("example = " + v);
        return v;
    }

    public Integer example2() {
        Supplier<Integer> function = () -> this.i * 2;
        Integer v = function.get();
        System.out.println("example2 = " + v);
        return v;
    }

    public static Integer example3(int i ) {
        Supplier<Integer> function = () -> i * 2;
        Integer v = function.get();
        System.out.println("example3 = " + v);
        return v;
    }

    public static Integer example4() {
        int i = 30;
        Supplier<Integer> function = () -> i * 2;
        Integer v = function.get();
        System.out.println("example4 = " + v);
        return v;
    }


    public static void main(String[] args) {

        Example example = new Example();
        example.example();
        example.example2();
        example3(10);
        example4();


    }
}
