package com.java.study.async.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;


/**
 * CompletableFuture.allOf 두개의 작업을 하나로 합치기
 *
 * handleAsync 메서드로 성공, 실패 캐치하기
 */
public class AsyncTest5 {

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
                        System.out.println("작업1 예외 처리: " + exception.getMessage());
                        return "작업1 [실패]";
                    }
                    return result;
                });


        CompletableFuture<String> future2 = CompletableFuture
                .supplyAsync((() -> {
                    System.out.println("작업2 스레드: " + Thread.currentThread().getName());
                    if (1 == 1) {
                        throw new RuntimeException("빵!");
                    }
//                    sleep(2000);
                    return "작업2";
                }))
                .handleAsync((result, exception) -> {    // 다른 스레드에서 실행
                    System.out.println("작업2 handleAsync 스레드: " + Thread.currentThread().getName());
                    if (exception != null) {
                        System.out.println("작업2 예외 처리: " + exception.getMessage());
                        return "작업2 [실패]";
                    }
                    return result;
                });


        CompletableFuture<Void> allDone = CompletableFuture.allOf(future1, future2);
        allDone.join(); // 완료 대기

        // 각 접근
        String result1 = future1.join();
        String result2 = future2.join();

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);


    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

