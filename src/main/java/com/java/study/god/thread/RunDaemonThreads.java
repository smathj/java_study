package com.java.study.god.thread;

public class RunDaemonThreads {

    public static void main(String[] args) {

        RunDaemonThreads sample = new RunDaemonThreads();
        sample.checkThreadProperty();

    }

    public void checkThreadProperty() {

        ThreadSample thread1 = new ThreadSample();
        ThreadSample thread2 = new ThreadSample();
        ThreadSample daemonThread = new ThreadSample();

        System.out.println("thread1 id=" + thread1.getId());
        System.out.println("thread2 id=" + thread2.getId());

        System.out.println("thread1 name=" + thread1.getName());
        System.out.println("thread2 name=" + thread2.getName());

        System.out.println("thread1 priority=" + thread1.getPriority());
        System.out.println("thread2 priority=" + thread2.getPriority());

        daemonThread.setDaemon(true);
        System.out.println("thread1 isDaemon=" + thread1.isDaemon());
        System.out.println("thread2 isDaemon=" + thread2.isDaemon());
        System.out.println("daemonThread isDaemon=" + daemonThread.isDaemon());

    }

}
