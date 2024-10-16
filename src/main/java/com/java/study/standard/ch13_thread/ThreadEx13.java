package com.java.study.standard.ch13_thread;

import javax.swing.*;

public class ThreadEx13 {

    public static void main(String[] args) throws Exception {

        ThreadEx13_1 th1 = new ThreadEx13_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + "입니다");
        th1.interrupt();    // interrupt() 를 호출하면, interrupted 상태가 true 가 된다
        System.out.println("isInterrupted() : " + th1.isInterrupted());

    }
}

class ThreadEx13_1 extends Thread {
    @Override
    public void run() {
        int i = 10;
                                            // interrupt() 를 호출하면, interrupted 상태가 true 가 된다
        while(i != 0 && !isInterrupted()) { // isInterrupted 현재의 interrupted 상태를 반환
            System.out.println(i--);
            for(long x=0; x<2500000000L; x++);  // 시간 지연
        }
        System.out.println("카운트가 종료되었습니다");
    }
}