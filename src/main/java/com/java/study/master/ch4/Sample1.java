package com.java.study.master.ch4;

import java.util.Arrays;
import java.util.Comparator;

public class Sample1 {

    public static void main(String[] args) {

        Integer[] array = {4,5,1,2,6,8,7};

//        Arrays.sort(array); // 기본 정렬 오름차순
        System.out.println(Arrays.toString(array));


        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                int o1Value = o1.intValue();
                int o2Value = o2.intValue();
                System.out.println("==================================");
                System.out.println("o1 = " + o1Value);
                System.out.println("o2 = " + o2Value);

                // 내림 차순을 위해 o2를 주체로 설정
                int i = o2.compareTo(o1);
                System.out.println("i = " + i);
                return i;
            }
        };

        Arrays.sort(array, comparator);
        System.out.println(Arrays.toString(array));

    }
}
