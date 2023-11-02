package com.java.study.standard.ch11_collection;

import java.util.TreeSet;

public class TreeSetEx2 {

    public static void main(String[] args) {

//        TreeSet set = new TreeSet(Comparator.reverseOrder());
        TreeSet set = new TreeSet();
        int[] score = {80, 95, 50, 35, 45, 65, 10, 100};

        for (int i = 0; i < score.length; i++) {
            set.add(new Integer(score[i]));
        }

        System.out.println("set = " + set);

        /**
         * 50 보다 작은값 이라면 ,
         * 즉 50이 헤드인 샘이다
         * 그러므로 headSet에 50이 들어간다
         * ! 단, 생성자에 정렬순서를 바꾸는 작업이 들어가면
         * ! 값이 달라진다
         */
        System.out.println("50보다 작은값 : " + set.headSet(new Integer(50)));

        /**
         * 50 보다 큰값 이라면,
         * 마찬가지로 50이 꼬리(자식)인 샘이다
         * 그러므로 tailSet에 50이 들어간다
         * ! 단, 생성자에 정렬순서를 바꾸는 작업이 들어가면
         * ! 값이 달라진다
         */
        System.out.println("50보다 큰값 : " + set.tailSet(new Integer(50)));

    }
}
