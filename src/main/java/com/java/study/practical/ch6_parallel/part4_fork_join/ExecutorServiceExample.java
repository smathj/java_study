package com.java.study.practical.ch6_parallel.part4_fork_join;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorServiceExample {

    public static void main(String[] args) {
        // ExecutorService 객체 생성

        // 싱글 스레드
//        ExecutorService execService = Executors.newSingleThreadExecutor();

        // 멀티 스레드
//        ExecutorService execService = Executors.newFixedThreadPool(2);

        // 등록한 스레드 갯수만큼 동시에 실행
        ExecutorService execService = Executors.newCachedThreadPool();

        // Thread 를 생성하고 실행시킨다
        execService.execute(new MyTask("TODO 1"));
        execService.execute(new MyTask("TODO 2"));
        execService.execute(new MyTask("TODO 3"));

        // ExecutorService 를 종료시킨다
        execService.shutdown();
    }

    static class MyTask implements Runnable {

        private String id;

        public MyTask(String id) {
            this.id = id;
        }

        @Override
        public void run() {
            for (int i = 0; i < 5; i++) {
                System.out.println("테스크 아이디 : " + id + ", running ..." + i);

                try {
                    TimeUnit.SECONDS.sleep(1);  // Thread.sleep

                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
