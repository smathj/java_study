package com.java.study.standard.cp14_stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdaEx5 {




    public static void main(String[] args) {

        // 파라미터 x , 리턴 o
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;

        // 파라미터 o, 리턴 x
        Consumer<Integer> c = i -> System.out.print(i + ",");

        // 파라미터 o, 리턴 o (boolean 고정)
        Predicate<Integer> p = i -> i % 2 == 0;

        // 파라미터 o, 리턴 o
        Function<Integer, Integer> f = i -> i / 10 * 10;    // i의 일의 자리를 없앤다

        List<Integer> list = new ArrayList<>();
        makeRandomList(s, list);
        System.out.println(list);
        printEvenNum(p, c, list);
        List<Integer> newList = doSomething(f, list);
        System.out.println(newList);

    }

    static <T> List<T> doSomething(Function<T,T> f, List<T> list) {

        List<T> newList = new ArrayList<T>(list.size());

        for (T i : list) {
            newList.add(f.apply(i));    // 파라미터 타입 T, 리턴 타입 T
        }

        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");

        for (T i : list) {
            if (p.test(i)) {        // 리턴 타입 boolean
                c.accept(i);        // 리턴 타입 void
            }
        }

        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());    // 파라미터 x, 리턴타입 T
        }
    }



}
