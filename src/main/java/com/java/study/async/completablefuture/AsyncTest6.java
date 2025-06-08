package com.java.study.async.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;


/**
 * 타임 아웃
 */
public class AsyncTest6 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> future1 = CompletableFuture
                .supplyAsync((() -> {
                    System.out.println("작업1 스레드: " + Thread.currentThread().getName());
                    sleep(2000);
                    return "작업1";
                }))
                .handle((result, exception) -> {    // 같은 스레드에서 실행
                    System.out.println("작업1 handle 스레드: " + Thread.currentThread().getName());
                    if (exception != null) {
                        System.out.println("예외 처리: " + exception.getMessage());
                        return "[실패] 작업1";
                    }
                    return result;
                });


        try {

            String result = future1.get(3, TimeUnit.SECONDS);
            System.out.println("result = " + result);


            // 캐싱 때문에 타임 아웃 걸리지 않는다
            String result2 = future1.get(2, TimeUnit.SECONDS);
            System.out.println("result2 = " + result2);

            // 캐싱 때문에 타임 아웃 걸리지 않는다
            String result3 = future1.get(1, TimeUnit.SECONDS);
            System.out.println("result3 = " + result3);


        } catch (TimeoutException e) {
            throw new RuntimeException(e);
        }


    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

