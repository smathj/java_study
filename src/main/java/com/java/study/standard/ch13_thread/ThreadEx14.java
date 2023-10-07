package com.java.study.standard.ch13_thread;

import javax.swing.*;

public class ThreadEx14 {

    public static void main(String[] args) throws Exception {

        ThreadEx14_1 th1 = new ThreadEx14_1();
        th1.start();
        String input = JOptionPane.showInputDialog("아무값이나 입력하세요");
        System.out.println("입력하신 값은 " + input + "입니다");
        th1.interrupt();    // interrupt() 를 호출하면, interrupted 상태가 true 가 된다
        System.out.println("isInterrupted() : " + th1.isInterrupted());

    }
}

class ThreadEx14_1 extends Thread {
    @Override
    public void run() {
        int i = 10;
                                            // interrupt() 를 호출하면, interrupted 상태가 true 가 된다
        while(i != 0 && !isInterrupted()) { // isInterrupted 현재의 interrupted 상태를 반환
            System.out.println(i--);
            try {
                Thread.sleep(1000); // 1초 지연
            } catch(InterruptedException e) {
                // slepp에 의해 스레드가 잠시 멈춘상태에서 interrupt 를 호출하면
                // InterruptedException 이 발생되고 쓰레드의 interrupted 상태는 false 로 자동 초기화 된다
                e.printStackTrace();
            }
        }
        System.out.println("카운트가 종료되었습니다");
    }
}