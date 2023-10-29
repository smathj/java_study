package com.java.study.standard.ch13_thread;

public class ThreadEx18 {

    public static void main(String[] args) {

        ThreadEx18_1 th1 = new ThreadEx18_1("*");
        ThreadEx18_1 th2 = new ThreadEx18_1("**");
        ThreadEx18_1 th3 = new ThreadEx18_1("***");

        th1.start();
        th2.start();
        th3.start();

        try {

            Thread.sleep(2000);
            th1.suspend();  // 1 - 일시정지

            Thread.sleep(2000);
            th2.suspend();  // 2 - 일시정지

            Thread.sleep(3000);
            th1.resume();   // 1- 실행대기

            Thread.sleep(3000);
            th1.stop();     // 1 - 소멸
            th2.stop();     // 2 - 소멸

            Thread.sleep(2000);
            th3.stop();     // 3- 소멸

        } catch(Exception e) {
            e.printStackTrace();
        }

    }



}

class ThreadEx18_1 implements Runnable {

    private boolean suspended = false;
    private boolean stopped = false;

    private Thread th;

    ThreadEx18_1(String name) {
        th = new Thread(this, name);    // Runnable, ThreadName
    }

    @Override
    public void run() {
        String name = th.getName();

        while (!stopped) {
            if (!suspended) {
                System.out.println(name);
                try {
                    Thread.sleep(1000);
                } catch(InterruptedException e) {
                    System.out.println(name + " - interrupted");
                }
            } else {
                Thread.yield(); // 쓰레드 양보
            }
        }
        System.out.println(name + " - stopped");
    }

    public void suspend() {
        suspended = true;
        th.interrupt(); // 쓰레드 대기
        System.out.println(th.getName() + " - interrupt() by suspend()");
    }

    public void stop() {
        stopped = true;
        th.interrupt(); // 쓰레드 대기
        System.out.println(th.getName() + " - interrupt() by stop()");
    }

    public void resume() {
        suspended = false;
    }

    public void start() {
        th.start();
    }
}
