package com.java.study.fire.functionInterface.onemore;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Ex14_2 {
    public static void main(String[] args) {

        // 파라미터 없이 반환형만 있는 인터페이스( get() )
        // ! get
        Supplier<Integer> s = () -> (int) (Math.random() * 100) + 1;
        // 파라미터는 있고 반환이 없음(void)
        // ! accept
        Consumer<Integer> c = i -> System.out.print(i + ", ");
        // 파라미터는 있고 boolean을 반환함
        // ! test
        Predicate<Integer> p = i -> i % 2 == 0; // 짝수 체크
        // 파라미터는 있고 리턴타입도 있음
        // ! apply
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
            newList.add(f.apply(i));
        }

        return newList;
    }

    static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
        System.out.print("[");
        for (T i : list) {
            if(p.test(i)) {
                c.accept(i);
            }
        }
        System.out.println("]");
    }

    static <T> void makeRandomList(Supplier<T> s, List<T> list) {
        for (int i = 0; i < 10; i++) {
            list.add(s.get());
        }
    }





}
