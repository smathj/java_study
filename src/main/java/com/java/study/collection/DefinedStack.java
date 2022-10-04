package com.java.study.collection;


import java.util.ArrayDeque;
import java.util.Deque;

interface DIStack<E> {
    public boolean push(E item);
    public E pop();
}

// * 큐를 이용해서 스택을 구현
class DCStack<E> implements DIStack<E> {
    private Deque<E> deq;

    public DCStack(Deque<E> deq) {
        this.deq = deq;
    }

    public boolean push(E item) {
        return deq.offerFirst(item);    // 제잎 위에서부터 넣기 (큐를 스택처럼)
    }

    public E pop() {
        return deq.pollFirst(); // 제일 마지막에 넣은것 꺼내기
    }
}


public class DefinedStack {
    public static void main(String[] args) {
        DIStack<String> stk = new DCStack<>(new ArrayDeque<String>());

        // PUSH 연산
        stk.push("1.Box");
        stk.push("2.Toy");
        stk.push("3.Robot");

        // POP 연산
        System.out.println(stk.pop());
        System.out.println(stk.pop());
        System.out.println(stk.pop());
    }
}
