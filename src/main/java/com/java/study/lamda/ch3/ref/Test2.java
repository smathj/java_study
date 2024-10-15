package com.java.study.lamda.ch3.ref;

import java.util.ArrayList;
import java.util.List;

/**
 * 생성자 참조
 */
public class Test2 {


    public static void usage() {
        List<Object> list = new ArrayList<>();
        initialize(list, Person::new, "홍길동", 10);


        List<Object> list2 = new ArrayList<>();
        PersonFactory factory = Person::new;
        initialize(list2, factory, "이차돌", 20);

    }

    public static void initialize(List<Object> list, PersonFactory factory, String name, int age) {
        for (int i = 0; i < 10; i++) {
            list.add(factory.create(name, age));
        }
        System.out.println("list = " + list);
    }

    public static void main(String[] args) {
        usage();
    }
}
