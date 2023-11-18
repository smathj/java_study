package com.java.study.first.thread_pool;

class MyThread extends Thread {
    public void run() {
        System.out.println("MyThread가 실행 중입니다...");
        try {
            Thread.sleep(2000); // 어떤 작업을 모방하기 위해 2초간 잠들었다가 깨어남
        } catch (InterruptedException e) {
            System.out.println("스레드가 중단되었습니다");
        }
        System.out.println("MyThread가 완료되었습니다.");
    }
}

public class JoinExample {
    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.start();

        System.out.println("Main 스레드가 실행 중입니다...");

        try {
            thread.join(); // 'thread'가 완료될 때까지 기다림
        } catch (InterruptedException e) {
            System.out.println("Main 스레드가 중단되었습니다");
        }

        System.out.println("Main 스레드가 완료되었습니다.");
    }
}