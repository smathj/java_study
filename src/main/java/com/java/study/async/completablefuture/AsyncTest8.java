package com.java.study.async.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * completedFuture
 */
public class AsyncTest8 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {



        CompletableFuture<Integer> integerCompletableFuture = CompletableFuture.completedFuture(1);

        Integer join = integerCompletableFuture.join();
        System.out.println("join = " + join);


    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

