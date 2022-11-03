package com.java.study.references;

import java.util.function.Function;

public class StringMaker {
    public static void main(String[] args) {
        // 파라미터 타입, 리턴 타입
//        Function<char[], String> f = ar -> {
//            return new String(ar);
//        };

        // 생성자 참조 방식
        Function<char[], String> f = String::new;

        char[] src = {'R', 'o', 'b', 'o', 't'};
        String str = f.apply(src);
        System.out.println(str);

    }
}
