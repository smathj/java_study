package com.java.study.collection;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListQueue {
    public static void main(String[] args) {
        // 큐는 FIFO(First-in-First-out) 첫놈이 맨 먼저 나감
        Queue<String> que = new LinkedList<>(); // LinkedList 는 List, Queue의 구현체
        que.offer("Box");
        que.offer("Toy");
        que.offer("Robot");

        // 무엇이 다음에 나올지 확인
        System.out.println("next : " + que.peek());

        // 첫번째, 두번째 인스턴스 꺼내기
        System.out.println(que.poll()); // 1 Box
        System.out.println(que.poll()); // 2 Toy

        // 무엇이 다음에 나올지 확인
        System.out.println("next : " + que.peek());

        // 마지막 인스턴스 꺼내기
        System.out.println(que.poll()); // 3 Robot
    }
}
