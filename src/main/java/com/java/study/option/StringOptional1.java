package com.java.study.option;

import java.util.Optional;

public class StringOptional1 {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of(new String("Toy1"));
        Optional<String> os2 = Optional.ofNullable(new String("Toy2"));
        Optional<String> os3 = Optional.ofNullable(null);

        if (os1.isPresent()) {  // 내용물이 존재하면 true
            System.out.println(os1.get());  // 내용물 반환 Wrapper 클래스 꺼냄
            System.out.println(os1);
        }

        if (os2.isPresent()) {
            System.out.println(os2.get());
            System.out.println(os2);
        }

        if (!os3.isPresent()) {
            System.out.println(os3);
        }
    }
}
