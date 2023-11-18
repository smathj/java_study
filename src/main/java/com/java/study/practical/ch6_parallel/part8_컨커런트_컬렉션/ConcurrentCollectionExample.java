package com.java.study.practical.ch6_parallel.part8_컨커런트_컬렉션;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConcurrentCollectionExample {

    private BlockingQueue<Integer> queue = new LinkedBlockingQueue<Integer>(5);

    // 항목을 생성하는 클래스로 Queue에 데이터를 추가하는 역할을 한다
    Runnable producer = () -> {
        Random random = new Random();

        try {
            TimeUnit.SECONDS.sleep(1);
            int num = random.nextInt(100);
            queue.put(num);
            System.out.println("생성한 항목 값 : " + num + ", 큐의 크기 : " + queue.size());
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    };

    // 항목을 소비하는 클래스. Queue에 쌓여 있는 항목을 처리한다
    Runnable consumer = () -> {
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println("    소비한 항목 값 : " + queue.take() + ", 큐의 크기 : " + queue.size());
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    };

    public void execute(int producerSize, int consumerSize) {
        // 생성자 스레드 생성
        for (int i = 0; i < producerSize; i++) {
            new Thread(producer, "생성자 " + (i+1)).start();
        }
        // 소비자 스레드 생성
        for (int i = 0; i < consumerSize; i++) {
                new Thread(consumer, "소비자 " + (i+1)).start();
        }
    }

    public static void main(String[] args) throws Exception {
        ConcurrentCollectionExample example = new ConcurrentCollectionExample();
        example.execute(7,9);
    }



}
