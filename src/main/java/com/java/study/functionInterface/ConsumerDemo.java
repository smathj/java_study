package com.java.study.functionInterface;

import java.util.function.Consumer;

public class ConsumerDemo {
    public static void main(String[] args) {
        Consumer<String> c = s -> System.out.println(s);
        c.accept("짖어");
        c.accept("짖지마");
        
    }
    
}
