package com.java.study.fire.collection;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapIteration {
    public static void main(String[] args) {
        // * 정렬 상태를 유지한다
        TreeMap<Integer, String> map = new TreeMap<>();
        map.put(45, "Brown");
        map.put(37, "James");
        map.put(23, "Martin");


        // Key만 담고 있는 컬렉션 인스턴스 생성
        Set<Integer> ks = map.keySet();

        System.out.println("==============================================");

        for (Integer n : ks) {
            System.out.print(n.toString() + "\t");
        }
        System.out.println();
        System.out.println("==============================================");

        // 전체 Value 출력
        for (Integer n : ks) {
            System.out.print(map.get(n).toString() + "\t");
        }
        System.out.println();
        System.out.println("==============================================");

        // 전체 Value 출력 ( 반복자 기반 )
        for (Iterator<Integer> itr = ks.iterator(); itr.hasNext(); ) {
            System.out.print(map.get(itr.next())  + "\t");
        }
        System.out.println();
        System.out.println("==============================================");
    }
}
