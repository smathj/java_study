package com.java.study.async;

public class Example1 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("백그라운드 작업 실행");
        });

        thread.start();

    }
}
