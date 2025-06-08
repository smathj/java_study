package com.java.study.async.countdownlatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class AsyncComparison {

    public static void main(String[] args) {

        System.out.println("=== 1. Future 방식 ===");
        futureExample();

        System.out.println("\n=== 2. CountDownLatch 방식 ===");
        countDownLatchExample();

        System.out.println("\n=== 3. CompletableFuture 방식 ===");
        completableFutureExample();
    }

    // 1. Future 방식: 결과값을 받아야 할 때
    public static void futureExample() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        List<Future<String>> futures = new ArrayList<>();

        long start = System.currentTimeMillis();

        // 작업 제출
        for (int i = 1; i <= 3; i++) {
            final int taskNum = i;
            Future<String> future = executor.submit(() -> {
                sleep(1000);
                return "결과 " + taskNum;
            });
            futures.add(future);
        }

        // 결과 수집
        try {
            for (Future<String> future : futures) {
                System.out.println("받은 결과: " + future.get());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Future 소요시간: " + (System.currentTimeMillis() - start) + "ms");
        executor.shutdown();
    }

    // 2. CountDownLatch 방식: 결과값은 필요없고 완료만 기다릴 때
    public static void countDownLatchExample() {
        ExecutorService executor = Executors.newFixedThreadPool(2);
        CountDownLatch latch = new CountDownLatch(3);

        long start = System.currentTimeMillis();

        // 작업 제출
        for (int i = 1; i <= 3; i++) {
            final int taskNum = i;
            executor.submit(() -> {
                try {
                    sleep(1000);
                    System.out.println("작업 " + taskNum + " 완료");
                } finally {
                    latch.countDown();  // 1개 소모
                }
            });
        }

        try {
            latch.await(); // 모든 작업 완료 대기
            System.out.println("CountDownLatch 소요시간: " + (System.currentTimeMillis() - start) + "ms");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        executor.shutdown();
    }

    // 3. CompletableFuture 방식: 가장 현대적이고 유연함
    public static void completableFutureExample() {
        long start = System.currentTimeMillis();

        // 작업 제출
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "결과 1";
        });

        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "결과 2";
        });

        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> {
            sleep(1000);
            return "결과 3";
        });

        // 모든 작업 완료 대기
        CompletableFuture<Void> allTasks = CompletableFuture.allOf(future1, future2, future3);

        try {
            allTasks.get(); // 완료 대기

            // 결과 출력
            System.out.println("받은 결과: " + future1.get());
            System.out.println("받은 결과: " + future2.get());
            System.out.println("받은 결과: " + future3.get());

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("CompletableFuture 소요시간: " + (System.currentTimeMillis() - start) + "ms");
    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
