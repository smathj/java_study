package com.java.study.standard.ch11_collection.test;

import org.apache.logging.log4j.util.PropertySource;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class SetTest1 {

    public static void main(String[] args) {


        // 역순
//        SortedSet<Integer> set = new TreeSet<>(Comparator.reverseOrder());

        // 디폴트
        SortedSet<Integer> set = new TreeSet<>();
        set.add(3);
        set.add(1);
        set.add(2);
        set.add(5);


        Integer i = set.stream().max(Integer::compareTo).get();
        System.out.println("i = " + i);


    }
}
