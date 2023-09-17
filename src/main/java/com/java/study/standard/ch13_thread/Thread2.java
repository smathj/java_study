package com.java.study.standard.ch13_thread;

public class Thread2 {

    public static void main(String[] args) {

        Thread2_1 t1 = new Thread2_1();
        t1.start();
    }

}

class Thread2_1 extends Thread {
    @Override
    public void run() {
        throwException();
//        super.run();
    }

    public void throwException() {
        try {
            throw new Exception();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

}
