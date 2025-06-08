package com.java.study.async.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncTest2 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        System.out.println("작업 시작");

        CompletableFuture<Void> job1 = CompletableFuture.runAsync(() -> {
            sleep(1000);
            System.out.println("작업1 완료");
        });

        CompletableFuture<Void> job2 = CompletableFuture.runAsync(() -> {
            sleep(3000);
            System.out.println("작업2 완료");
        });

        // 두 작업이 모두 완료 될 떄 까지 대기
        CompletableFuture.allOf(job1, job2).join();

        System.out.println("작업 완료");

    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
