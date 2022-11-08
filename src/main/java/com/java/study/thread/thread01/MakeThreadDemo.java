package com.java.study.thread.thread01;

public class MakeThreadDemo {
    public static void main(String[] args) {
        Runnable task = () -> {
            int n1 = 10;
            int n2 = 20;
            String name = Thread.currentThread().getName();
            System.out.println(name + " = " + (n1 + n2));   // Thread-0 = 30
        };

        Thread t = new Thread(task);
        t.start();  // ! 쓰레드 생성 및 실행
        System.out.println("End = " + Thread.currentThread().getName());

    }
}
