package com.java.study.collection;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;


// * 내림 차순
class AgeComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer n1, Integer n2) {
//        System.out.println("=========================================");
//        System.out.println("n1 : " + n1.intValue());
//        System.out.println("n2 : " + n2.intValue());
        return n2.intValue() - n1.intValue();
    }
}

public class ComparatorTreeMapIteration {
    public static void main(String[] args) {

        // * 정렬 상태를 유지한다
        TreeMap<Integer, String> map = new TreeMap<>(new AgeComparator());
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
