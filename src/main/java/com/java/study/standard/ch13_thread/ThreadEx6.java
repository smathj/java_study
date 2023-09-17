package com.java.study.standard.ch13_thread;

import javax.swing.*;

public class ThreadEx6 {
    public static void main(String[] args) {

        String input = JOptionPane.showInputDialog("아무 값이나 입력하세요");
        System.out.println("입력값 = " + input);

        for (int i = 10; i > 0; i--) {
            System.out.println("i = " + i);
            try {
                Thread.sleep(1000);
            } catch(Exception e) {
            }
        }
    }
}
