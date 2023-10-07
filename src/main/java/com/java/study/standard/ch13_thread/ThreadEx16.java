package com.java.study.standard.ch13_thread;

public class ThreadEx16 {

    public static void main(String[] args) {

        RunImplEx16 r1 = new RunImplEx16();
        RunImplEx16 r2 = new RunImplEx16();
        RunImplEx16 r3 = new RunImplEx16();

        Thread th1 = new Thread(r1, "*");
        Thread th2 = new Thread(r2, "**");
        Thread th3 = new Thread(r3, "***");
        th1.start();
        th2.start();
        th3.start();

        try {

            Thread.sleep(2000);
            r1.suspend();                  // 쓰레드 th1 을 잠시 중단시킨다
            Thread.sleep(2000);
            r2.suspend();                  // 쓰레드 th2 을 잠시 중단시킨다
            Thread.sleep(3000);
            r1.resume();                   // 쓰레드 th1 이 다시 동작하도록 한다
            Thread.sleep(3000);
            r1.stop();                     // 쓰레드 th1 을 강제종료 시킨다
            r2.stop();
            Thread.sleep(2000);
            r3.stop();
        } catch(InterruptedException e) {

        }
    }
}

class RunImplEx16 implements Runnable {

    volatile boolean suspended = false;
    volatile boolean stopped = false;

    @Override
    public void run() {
        while (!stopped) {
            if (!suspended) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {

                }
            }
        }
        System.out.println(Thread.currentThread().getName() + " - stopped");
    }

    public void suspend() {
        suspended = true;
    }
    public void resume() {
        suspended = false;
    }
    public void stop() {
        stopped = true;
    }
}
