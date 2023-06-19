package com.java.study.god.thread;

public class Thread02  extends Thread {

    // 구현
    @Override
    public void run() {
        try {
            Thread.sleep(2000);
            System.out.println("서브 스레드 종료");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {

        Thread02 thread02 = new Thread02();
        String name = thread02.getName();
        int priority = thread02.getPriority();
        boolean daemon = thread02.isDaemon();
        System.out.println("daemon = " + daemon);
        System.out.println("priority = " + priority);
        System.out.println("name = " + name);

        // 시작
        thread02.start();
        System.out.println("메인 스레드 종료");


    }
}
