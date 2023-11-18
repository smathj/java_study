package com.java.study.first.thread_pool;

public class Test07 {
    public static void main(String[] args) {
        Phone calling = new Phone();
        calling.start();
        // --------------------------
        try {
            calling.join(); // 메인 스레드에 Phone 스레드를 조인시키고 , 이 스레드가 종료되길 기다린다
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // --------------------------
        for (int i = 1; i <= 1000; i++) {
            System.out.println("음식 먹기 : " + i);
        }
    }
}
