package com.java.study.async.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * getNow - 즉시 가져오기, 안나오면 기본값
 */
public class AsyncTest9 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello World");


        sleep(1);
        String result = future.getNow("급하게");


        System.out.println("result = " + result);

        System.out.println("future.isDone() = " + future.isDone());


    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

