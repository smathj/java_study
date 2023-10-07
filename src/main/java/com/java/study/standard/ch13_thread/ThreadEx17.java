package com.java.study.standard.ch13_thread;

public class ThreadEx17 {

    public static void main(String[] args) {


        ThreadEx17_1 th1 = new ThreadEx17_1("*");
        ThreadEx17_1 th2 = new ThreadEx17_1("**");
        ThreadEx17_1 th3 = new ThreadEx17_1("***");
        th1.start();
        th2.start();
        th3.start();

        try {

            Thread.sleep(2000);
            th1.suspend();                  // 쓰레드 th1 을 잠시 중단시킨다
            Thread.sleep(2000);
            th2.suspend();                  // 쓰레드 th2 을 잠시 중단시킨다
            Thread.sleep(3000);
            th1.resume();                   // 쓰레드 th1 이 다시 동작하도록 한다
            Thread.sleep(3000);
            th1.stop();                     // 쓰레드 th1 을 강제종료 시킨다
            th2.stop();
            Thread.sleep(2000);
            th3.stop();
        } catch(InterruptedException e) {

        }
    }
}

class ThreadEx17_1 implements Runnable {

    volatile boolean suspended = false;
    volatile boolean stopped = false;

    Thread th;

    public ThreadEx17_1(String name) {
        th = new Thread(this, name);
    }

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
    public void start() {
        th.start();
    }
}
