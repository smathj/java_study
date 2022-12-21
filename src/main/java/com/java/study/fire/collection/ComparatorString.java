package com.java.study.fire.collection;


import java.util.Comparator;
import java.util.TreeSet;

class StringComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        return s1.length() - s2.length();   // 짧은 순 정렬
    }
}



public class ComparatorString {
    public static void main(String[] args) {
        TreeSet<String> tree = new TreeSet<>(new StringComparator());
        tree.add("Box");
        tree.add("Rabbit");
        tree.add("Robot");

        for (String s : tree) {
            System.out.println(s.toString());
        }
    }
}
