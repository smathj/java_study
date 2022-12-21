package com.java.study.modern.functionalinterface;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerMain {
    public static void main(String[] args) {

        ConsumerMain.forEach(Arrays.asList(1, 2, 3, 4, 5), (Integer i) -> System.out.println(i));
//        ConsumerMain.forEach(Arrays.asList(1, 2, 3, 4, 5), System.out::println);
    }


    public static <T> void forEach(List<T> list, Consumer<T> c) {
        for (T t : list) {
            c.accept(t);
        }
    }
}
