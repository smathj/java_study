package com.java.study.first.thread_pool;

import java.util.concurrent.TimeUnit;

public class Test08 {
    public static void main(String[] args) {
        PrintThread t = new PrintThread();
        System.out.println("[1] state = " + t.getState().name());
        t.start();
        System.out.println("[2] state = " + t.getState().name());
        t.interrupt();  // InterruptedException 예외를 던짐
        System.out.println("[3] state = " + t.getState().name());
    }

    public static class PrintThread extends Thread {

        @Override
        public void run() {
            try {
                for (int i = 0; i < 10; i++) {
                    TimeUnit.SECONDS.sleep(1);
                    System.out.println("출력 : " + i);
                }

            } catch(InterruptedException e) {
                System.out.println("Interrupt가 발생하여 Sleep 상태를 종료함");

            }
        }
    }

}
