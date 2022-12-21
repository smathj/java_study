package com.java.study.fire.collection2.test;

import java.util.*;

class TestUp implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // 오름차순을 예상한다
        System.out.print("o1 : " + o1.intValue() + ", o2 : " + o2.intValue() + "\t");

        // 앞이 크면
        if ((o1.intValue() - o2.intValue()) > 0) {
            System.out.println("(+)" );
            return 1;
//            return -1;
        // 뒤가 크면
        } else {
            System.out.println("(-)" );
            return -1;
//            return 1;
        }

//        return o1.intValue() - o2.intValue();
    }
}

class TestDown implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        // 오름차순을 예상한다
        return o2.intValue() - o1.intValue();
    }
}


public class Test01 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(4, 5, 3, 2, 1, 6, 7);


        TestUp upDown = new TestUp();
        Collections.sort(list, upDown);

        for (Integer integer : list) {
            System.out.print(integer + "\t");
        }
        System.out.println();

    }
}
