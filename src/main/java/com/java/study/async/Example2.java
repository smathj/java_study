package com.java.study.async;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class Example2 {

    public static void main(String[] args) {


        // 4개의 스레드를 항상 유지하는 스레드 풀 생성
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        // 1단계: 모든 작업을 큐에 제출 (submit만 하고 get은 안함)
        List<Future<String>> futures = new ArrayList<>();

        // 작업 큐에 추가
        for (int i = 1; i <= 9; i++) {

            try {
                AtomicInteger atomicInteger = new AtomicInteger(i);
                Future<String> future = executorService.submit(() -> {
                    // 시간이 걸리는 작업
                    sleep(1000);
                    return "작업완료 " + atomicInteger;
                });

                futures.add(future);


            } catch (Exception e) {
                throw new RuntimeException(e);
            }


        }

        /**
         * 콘솔에서 2개씩 나오는걸 확인
         * 스레드 풀이 2개라서 그럼
         */
        for (Future<String> future : futures) {

            try {
                String resultMessage = future.get();
                System.out.println("resultMessage = " + resultMessage);
            } catch(Exception e) {
                e.printStackTrace();
            }
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
