package com.java.study.fire.option;

import java.util.Optional;

public class OptionalMap {
    public static void main(String[] args) {
        Optional<String> os1 = Optional.of("Optional String");
        Optional<String> os2 = os1.map(s -> s.toUpperCase());
        System.out.println(os2.get());

        // map은 내부적으로 apply 실행하는 로직이 있다
        // 즉 람다식을 넘겨주면 알아서 실행해준다
        Optional<String> os3 = os1.map(s -> s.replace(' ', '_'))
                .map(s -> s.toLowerCase());
        System.out.println(os3.get());
    }
}
