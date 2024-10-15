package com.java.study.lamda.ch3.ref;

import org.apache.commons.collections4.Factory;

import java.util.ArrayList;
import java.util.List;

/**
 * 생성자 참조
 */
public class Test1_2 {


    public void usage() {
        List<Object> list = new ArrayList<>();
//        initialize(list, ConstantFactory.NULL_INSTANCE);
//        initialize(list, () -> new Object());
//        initialize(list, Object::new);
        initialize(list, () -> new String("yo"));
//        initialize(list, String::new);

    }

    public void initialize(List<Object> list, Factory<Object> factory) {
        for (int i = 0; i < 10; i++) {
            list.add(factory.create());
        }
        System.out.println("list = " + list);
    }

    public static void main(String[] args) {
        Test1_2 ist = new Test1_2();
        ist.usage();
    }
}
