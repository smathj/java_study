package com.java.study.lamda.ch3.ref;

import java.util.ArrayList;
import java.util.List;

/**
 * 생성자 참조
 */
public class Test1 {


    public void usage() {
        List<Object> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new Object());
        }
    }

    public static void main(String[] args) {

    }
}
