package com.java.study.first.thread_pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Test09 {

    public static void main(String[] args) {

        ExecutorService threadPool1 = Executors.newFixedThreadPool(10);
        ExecutorService threadPool2 = Executors.newCachedThreadPool();


        // execute() -> void
        // submit() -> Future
        threadPool1.execute(new Task());
        threadPool1.execute(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("스레드 작업 2 - " + i);

            }
        });

//        List<Runnable> runnables = threadPool1.shutdownNow();
//        System.out.println("runnables = " + runnables);
        threadPool1.shutdown();
        threadPool2.shutdown();

    }

    static class Task implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("스레드 작업 1 - " + i);
            }
        }
    }

}
