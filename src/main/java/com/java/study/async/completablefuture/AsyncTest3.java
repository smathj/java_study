package com.java.study.async.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncTest3 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        /**
         * 메서드 체이닝
         */
        CompletableFuture<Void> completableFuture = CompletableFuture.supplyAsync(() -> 1)
                .thenApply((result) -> result + 2)
                .thenApply((result) -> result + 3)
                .thenAccept((result) -> {
                    System.out.println("최종 결과: " + result);
                });

        completableFuture.get();


    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
