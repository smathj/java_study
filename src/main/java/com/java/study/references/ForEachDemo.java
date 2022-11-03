package com.java.study.references;

import java.util.Arrays;
import java.util.List;

public class ForEachDemo {
    public static void main(String[] args) {
        List<String> ls = Arrays.asList("Pizza, Chicken");
        ls.forEach(s -> System.out.println(s));
        ls.forEach(System.out::println);

    }
}
