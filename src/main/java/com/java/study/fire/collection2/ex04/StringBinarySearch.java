package com.java.study.fire.collection2.ex04;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringBinarySearch {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Box");
        list.add("Robot");
        list.add("Apple");

        Class<?> myClass = list.getClass();
        System.out.println("myClass.getName() : " +  myClass.getName());                // java.util.ArrayList
        System.out.println("myClass.getSimpleName() : " +  myClass.getSimpleName());    // ArrayList
        System.out.println("myClass.getPackage() : " +  myClass.getPackage());          // package java.util


        Collections.sort(list); // 오름차순 정렬
        int idx = Collections.binarySearch(list, "Robot");
        System.out.println("idx = " + idx);
        System.out.println(list.get(idx));
    }
}
