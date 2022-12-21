package com.java.study.fire.thread.thread01;

public class CurrentThreadName {
    public static void main(String[] args) {
        Thread ct = Thread.currentThread();
        String name = ct.getName();
        System.out.println(name);
    }
}
