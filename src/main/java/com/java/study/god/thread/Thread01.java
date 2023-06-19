package com.java.study.god.thread;

public class Thread01 implements Runnable{

    @Override
    public void run() {
        System.out.println("Runnable 의 run() 실행");
    }

    public static void main(String[] args) {

        Thread01 thread01 = new Thread01();
        thread01.run();

    }
}
