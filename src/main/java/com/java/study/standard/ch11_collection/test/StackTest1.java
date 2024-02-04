package com.java.study.standard.ch11_collection.test;

import java.util.SortedSet;
import java.util.Stack;

public class StackTest1 {

    public static void main(String[] args) {

        Stack<Integer> st = new Stack<Integer>();
        System.out.println("empty = " + st.empty());
        System.out.println("capacity = " + st.capacity());

        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println("empty = " + st.empty());
        System.out.println("capacity = " + st.capacity());

        System.out.println("st.search(1) = " + st.search(1));   // 3
        System.out.println("st.search(2) = " + st.search(2));   // 2
        System.out.println("st.search(3) = " + st.search(3));   // 1(첫번쨰, = 제일 위)
        System.out.println("st.search(4) = " + st.search(4));   // -1

        // 헤드 값만 복사
        System.out.println("st.peek() = " + st.peek());
        System.out.println("st.peek() = " + st.peek());
        System.out.println("st.peek() = " + st.peek());

        // 빼서 가져오기 (EmptyStackException 예외 발생 가능)
        System.out.println("st.pop() = " + st.pop());
        System.out.println("st.pop() = " + st.pop());
        System.out.println("st.pop() = " + st.pop());
        System.out.println("st.pop() = " + st.pop());


    }


}
