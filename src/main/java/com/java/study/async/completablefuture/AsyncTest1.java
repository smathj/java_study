package com.java.study.async.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncTest1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        System.out.println("작업 시작");


        // CompletableFuture.runAsync - 리턴이 없다
        CompletableFuture<Void> job1 = CompletableFuture.runAsync(() -> {
            System.out.println("작업1");
        });

        // CompletableFuture.supplyAsync - 리턴 값이 있다
        CompletableFuture<String> job2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("작업2");
            return "작업2";
        });

        Void job1Result = job1.get();
        String job2Result = job2.get();

        System.out.println("job1Result = " + job1Result);
        System.out.println("job2Result = " + job2Result);

    }

}
