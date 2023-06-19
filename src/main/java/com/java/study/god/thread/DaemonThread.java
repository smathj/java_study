package com.java.study.god.thread;

public class DaemonThread extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(Long.MAX_VALUE);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DaemonThread thread = new DaemonThread();
        thread.setDaemon(true);
        thread.start();
    }
}
