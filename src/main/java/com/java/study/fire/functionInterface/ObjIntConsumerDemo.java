package com.java.study.fire.functionInterface;

import java.util.function.ObjIntConsumer;

public class ObjIntConsumerDemo {
    public static void main(String[] args) {
        ObjIntConsumer<String> c = (s, i) -> System.out.println(i + ". " + s);
//        ObjIntConsumer<String> c = (String s, int i) -> System.out.println(i + ". " + s);
        
        int n = 1;
        c.accept("가", n++);
        c.accept("나", n++);
        c.accept("다", n);
    }
}
