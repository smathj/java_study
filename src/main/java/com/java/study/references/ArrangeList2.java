package com.java.study.references;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Consumer;

public class ArrangeList2 {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 3, 5, 7, 9);
        ls = new ArrayList<>(ls);

        // l의 타입이 List<Integer>
        Consumer<List<Integer>> c = Collections::reverse;    // 클래스.정적메서드 를 메서드 참조 표현식으로 나타냄 ( :: 연산자를 사용한다 )

        c.accept(ls);   // 순서 뒤집기 실행, 전달 인자 ls를 reverse에 그대로 전달하게된다
        System.out.println(ls);


        // Consumer<T>  void accept(T t)

    }
}
