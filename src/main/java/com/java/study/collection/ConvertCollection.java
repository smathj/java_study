package com.java.study.collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class ConvertCollection {
    public static void main(String[] args) {

        List<String> lst = Arrays.asList("Box", "Toy", "Box", "Toy");
        ArrayList<String> list = new ArrayList<>(lst);

        System.out.println("========================================");
        for (String s : list) {
            System.out.println(s.toString());
        }
        System.out.println("========================================");

        // 중복된 인스턴스를 걸러 내기 위한 작업
        HashSet<String> set = new HashSet<>(list);

        // 원래대로 ArrayList<String> 인스턴스로 저장물을 옮긴다
        list = new ArrayList<>(set);

        for (String s : list) {
            System.out.println(s.toString());
        }
        System.out.println("========================================");

    }
}
