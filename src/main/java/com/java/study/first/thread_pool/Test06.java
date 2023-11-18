package com.java.study.first.thread_pool;

import java.util.ArrayList;
import java.util.List;

public class Test06 {

    public static void main(String[] args) {
        Pool pool = new Pool(); // 자원 클래스 (동기화 메서드)
        Thread productGet = new Thread(new ProductGet(pool));   // Runnable
        Thread productAdd = new Thread(new ProductAdd(pool));   // Runnable

        productGet.start(); // 소비 스레드
        productAdd.start(); // 생산 스레드

    }

    // 자원 클래스
    public static class Pool {

        List<String> products = new ArrayList<>();

        // 소비 메서드
        public synchronized void get() throws InterruptedException {
            if (products.size() == 0) {
                System.out.println("[🗽] 소비 대기");
                wait(); // Runnable 상태의 스레드를 WAITING
            }
            products.remove(0);
            System.out.println("[🔥] 소비 / 재고 = " + products.size());
        }

        // 생산 메서드
        public synchronized void add(String value) {
            products.add(value);
            System.out.println("[⭕] 생산 / 재고 = " + products.size());
            System.out.println("[🌤] 소비 깨우기");
            notifyAll();    // WAITING 상태의 스레드를 Runnable (전부)
        }


    }


    // 소비 스레드 클래스
    public static class ProductGet implements Runnable {

        Pool pool;

        public ProductGet(Pool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            try {
                for (int i = 1; i <= 10; i++) {
                    pool.get();
                }
            } catch(InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // 생산 스레드 클래스
    public static class ProductAdd implements Runnable {

        Pool pool;

        public ProductAdd(Pool pool) {
            this.pool = pool;
        }

        @Override
        public void run() {
            for (int i = 1; i <= 10; i++) {
                pool.add("상품" + i);
            }
        }
    }



}
