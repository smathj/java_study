package com.java.study.god.collection.list;

import java.util.LinkedList;

public class List01 {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        for (int i = 1; i < 11; i++) {
            String text = "홍길동" + i;
            list.add(text);
        }

        for (String s : list) {
            System.out.println("s = " + s);
        }


    }
}
