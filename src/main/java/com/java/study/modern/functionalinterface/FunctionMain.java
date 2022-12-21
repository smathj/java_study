package com.java.study.modern.functionalinterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionMain {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("피자", "치킨", "아바타", "소고기", "12월05일");
        List<Integer> wordLengthList = FunctionMain.map(list, (String word) -> word.length());
//        List<Integer> wordLengthList = FunctionMain.map(list, String::length);
        for (Integer wordLength : wordLengthList) {
            System.out.println("wordLength = " + wordLength);
        }
    }

    public static <T,R> List<R> map(List<T> list, Function<T,R> f) {
        List<R> results = new ArrayList<>();
        for (T t : list) {
            results.add(f.apply(t));
        }
        return results;
    }
}
