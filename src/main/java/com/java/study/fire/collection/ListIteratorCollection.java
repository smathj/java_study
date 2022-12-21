package com.java.study.fire.collection;

import java.util.*;


public class ListIteratorCollection {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Toy", "Box", "Robot", "Box");
        list = new ArrayList<>(list);

        ListIterator<String> litr = list.listIterator();    // 양방향 반복자 획득

        String str;
        while (litr.hasNext()) {
            str = litr.next();
            System.out.print(str + " \t");
            if (str.equals("Toy")) {
                litr.add("Toy2");
            }
        }
        System.out.println();

        while (litr.hasPrevious()) {    // 오른쪽에서 왼쪽으로 이동을 위한 반복문
            str = litr.previous();
            System.out.print(str + " \t");
            if (str.equals("Robot")) {
                litr.add("Robot2");
            }
        }
        System.out.println();

        // 다시 왼쪽에서 오른쪽으로
        for (Iterator<String> itr = list.iterator(); itr.hasNext(); ) {
            System.out.print(itr.next() + " \t");
        }
        System.out.println();

    }
}
