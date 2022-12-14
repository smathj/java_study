package com.java.study.fire.references;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

class JustSort {
    public void sort(List<?> lst) {    // 인스턴스 메소드
        Collections.reverse(lst);
    }
} 

public class ArrangeList3 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
        ls = new ArrayList<>(ls);
        JustSort js = new JustSort();

        //Consumer<List<Integer>> c = e -> js.sort(e);    // 람다식 기반
        Consumer<List<Integer>> c = js::sort;    // 람다식 기반
        c.accept(ls);   // 람다식 실행
        System.out.println(ls);
    }
}
