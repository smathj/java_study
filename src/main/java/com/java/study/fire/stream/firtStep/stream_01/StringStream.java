package com.java.study.fire.stream.firtStep.stream_01;

import java.util.Arrays;
import java.util.stream.Stream;

public class StringStream {
    public static void main(String[] args) {
        String[] names = {"K", "O", "R"};
        Stream<String> stm = Arrays.stream(names);  // 스트림 생성
        stm.forEach(s -> System.out.println(s));    // 최종 연산 진행
    }
}
