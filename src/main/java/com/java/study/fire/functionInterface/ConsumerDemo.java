package com.java.study.fire.functionInterface;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
        c.accept("짖어");
        c.accept("짖지마");

        // v2
        Consumer<Integer> c2 = intParam -> System.out.println("입력 값 = " + intParam);
        c2.accept(1);
        c2.accept(2);

    }
    
}
