package com.java.study.async.countdownlatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleConcurrencyTest {

    private static int counter = 0; // Thread-Safe하지 않은 변수

    public static void main(String[] args) throws InterruptedException {

        int threadCount = 100;

        // 100 개의 스레드를 가진 스레드 풀 생성
        ExecutorService executor = Executors.newFixedThreadPool(threadCount);

        CountDownLatch latch = new CountDownLatch(1); // 시작 신호용

        // 100개 스레드 생성하고 대기시키기
        for (int i = 0; i < threadCount; i++) {
            executor.submit(() -> {
                try {
                    latch.await(); // 🚦 시작 신호 대기

                    // 동시 실행될 코드
                    counter++;

                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            });
        }

        System.out.println("모든 스레드 대기 중...");
        Thread.sleep(100); // 모든 스레드가 대기상태가 되도록

        System.out.println("🚀 동시 시작!");
        latch.countDown(); // 시작 신호! (모든 스레드 동시 실행)

        Thread.sleep(100); // 작업 완료 대기

        System.out.println("예상 결과: 100");
        System.out.println("실제 결과: " + counter);

        if (counter < 100) {
            System.out.println("❌ 레이스 컨디션 발생!");
        }

        executor.shutdown();
    }
}
