package com.java.study.fire.thread.thread02;


class Counter2 {
    int count = 0;  // 두 쓰레드에 의해 공유 되는 변수

    synchronized public void increment() {
        count++;    // 첫번째 쓰레드에 의해 실행되는 메서드
    }

    synchronized public void decrement() {
        count--;    // 두번째 쓰레드에 의해 실행되는 메서드
    }

    public int getCount() {
        return count;
    }
}

public class MutualAccessSyncMethod {

    public static Counter2 cnt = new Counter2();

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
                cnt.increment();    // 값 1 증가
                System.out.println("🌿 task1: " + cnt.getCount() + "[" + i + "]");
            }
        };
        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
                cnt.decrement();    // 값 1 감소
                System.out.println("🔥 task2: " + cnt.getCount() + "[" + i + "]");
            }
        };

        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        t1.start();
        t2.start();
        t1.join();  // t1이 참조하는 쓰레드의 종료를 기다린다, 즉 main 쓰레드 t1 쓰레드의 종료를 기다린다 ( await 처럼 )
        t2.join();  // t1이 참조하는 쓰레드의 종료를 기다린다, 즉 main 쓰레드 t2 쓰레드의 종료를 기다린다 ( await 처럼 )
        System.out.println("cnt = " + cnt.getCount());  // 항상 0
    }
}
