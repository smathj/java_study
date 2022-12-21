package com.java.study.fire.thread.thread03;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

class Counter {
    int count = 0;
    ReentrantLock criticObj = new ReentrantLock();

    public void increment() {
        criticObj.lock();
        try {
            count++;
        } finally {
            criticObj.unlock();
        }
    }

    public void decrement() {
        criticObj.lock();
        try {
            count--;
        } finally {
            criticObj.unlock();
        }
    }

    public int getCount() {
        return count;
    }
}

public class MutualAccessReentrantLock {
    public static Counter cnt = new Counter();

    public static void main(String[] args) throws InterruptedException {
        Runnable task1 = () -> {
            for (int i = 0; i < 1000; i++) {
                cnt.increment();
            }
        };

        Runnable task2 = () -> {
            for (int i = 0; i < 1000; i++) {
                cnt.decrement();
            }
        };

        ExecutorService exr = Executors.newFixedThreadPool(2);
        exr.submit(task1);
        exr.submit(task2);

        exr.shutdown();
        exr.awaitTermination(100, TimeUnit.SECONDS);    // 쓰레드 풀에 전달되 작업이 끝나기를 100초간 기다린다
        System.out.println(cnt.getCount());
        
    }

}
