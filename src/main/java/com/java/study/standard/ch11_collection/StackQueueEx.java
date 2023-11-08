package com.java.study.standard.ch11_collection;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueEx {

    public static void main(String[] args) {

        Stack<Object> st = new Stack<>();
        Queue<Object> q = new LinkedList<>();

        st.push("0");
        st.push("1");
        st.push("2");

        // offer 객체 저장 리턴 boolean
        q.offer("0");
        q.offer("1");
        q.offer("2");

        System.out.println("== Stack ==");
        while (!st.empty()) {
            System.out.println(st.pop());
        }


        System.out.println("== Queue ==");
        while (!q.isEmpty()) {
            // poll 꺼낸다 비어있으면 null 반환
            System.out.println(q.poll());
        }
    }
}
