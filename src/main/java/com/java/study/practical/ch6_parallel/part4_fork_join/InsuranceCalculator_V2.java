package com.java.study.practical.ch6_parallel.part4_fork_join;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InsuranceCalculator_V2 {

    // 동기
    public int calculatePrice(Map condition) {
        // 기본 가격
        int price = 10000;

        // 보험료 계싼하는 로직 대신 10초 대기하는 것으로 대체한다
        try {
            TimeUnit.SECONDS.sleep(10);
        } catch(Exception e) {
        }

        // 임의의 가격을 리턴한다
        return price;
    }

    // 비동기
    public Future<Integer> calculatePriceAsync(Map condition) {
        CompletableFuture<Integer> future = new CompletableFuture<>();

        // 스레드를 생성하고 실행할 작업을 CompletableFuture에 등록한다
        new Thread(() -> {
            int price = calculatePrice(condition);
            // 처리 상태에 대한 레퍼런스를 등록한다
            future.complete(price);
        }).start();

        return future;
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        InsuranceCalculator_V2 cal = new InsuranceCalculator_V2();

        // 5회에 걸쳐 계산한다
        for (int i = 0; i < 5; i++) {
            System.out.printf("계산 차수 %s : %s\n", (i+1), cal.calculatePriceAsync(null).get());
        }
    }
}
