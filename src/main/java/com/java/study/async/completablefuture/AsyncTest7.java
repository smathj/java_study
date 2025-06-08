package com.java.study.async.completablefuture;

import java.util.concurrent.*;


/**
 * 별도의 익스큐터 서비스 사용하기
 */
public class AsyncTest7 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        CompletableFuture<String> future1 = CompletableFuture
                .supplyAsync((() -> {
                    System.out.println("작업1 스레드: " + Thread.currentThread().getName());
                    return "작업1";
                }), executorService)
                .handle((result, exception) -> {    // 같은 스레드에서 실행
                    System.out.println("작업1 handle 스레드: " + Thread.currentThread().getName());
                    if (exception != null) {
                        System.out.println("예외 처리: " + exception.getMessage());
                        return "[실패] 작업1";
                    }
                    return result;
                });


        // supplyAsync 메서드의 두번째 파라미터로 익스큐터 서비스를 넣으면 자동 실행
        executorService.shutdown();


        sleep(3000);
        System.out.println("future1.isDone() = " + future1.isDone());


    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

