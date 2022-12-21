package com.java.study.fire.collection;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class ArrayDequeCollection {
    public static void main(String[] args) {
//        Deque<String> deq = new ArrayDeque<>(); // 배열을 기반하는 덱
        // 다음으로 변경가능, LinkedList는 Deque, List, Queue를 구현해서 가능함
        Deque<String> deq = new LinkedList<>();

        // 앞으로 넣고
        deq.offerFirst("1.Box");
        deq.offerFirst("2.Toy");
        deq.offerFirst("3.Robot");

        // 앞에서 꺼내기
        System.out.println(deq.pollFirst());    // 3
        System.out.println(deq.pollFirst());    // 2
        System.out.println(deq.pollFirst());    // 1
        System.out.println(deq.pollFirst());    // null
    }
}
