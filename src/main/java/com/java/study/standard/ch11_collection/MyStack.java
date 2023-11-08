package com.java.study.standard.ch11_collection;

import java.util.EmptyStackException;
import java.util.Vector;

public class MyStack extends Vector {

    public Object push(Object item) {
        addElement(item);
        return item;
    }

    public Object pop() {
        Object obj = peek();    // Stack에 저장된 마지막 요소를 가져온다
                                // 만일 Stack이 비어있으면 peek() 메서드가 EmptyStackException을 발생시킨다

        // 마지막 요소를 삭제한다
        removeElementAt(size() - 1);
        return obj;
    }

    public Object peek() {
        int len = size();

        if (len == 0) {
            throw new EmptyStackException();
        }
        // 맨위꺼 반환
        return elementAt(len - 1);
    }

    public boolean empty() {
        return size() == 0;
    }

    public int search(Object o) {
        int i = lastIndexOf(o);

        if (i >= 0) {
            return size() - 1;
        }

        return -1;
    }

}

