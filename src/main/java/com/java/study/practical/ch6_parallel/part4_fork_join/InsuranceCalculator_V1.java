package com.java.study.practical.ch6_parallel.part4_fork_join;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class InsuranceCalculator_V1 {
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
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(5);
        List<Future<Integer>> futureList = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            // 비동기 처리되도록 메서드를 호출하였다 = 스레드 풀에 등록
            Future<Integer> future = service.submit(() -> {
                return new InsuranceCalculator_V1().calculatePrice(null);
            });

            futureList.add(future);
        }

        // ----------------------------
        // 스레드 풀에 등록완료
        // ----------------------------

        futureList.forEach((future) -> {
            // 계산 결과를 출력한다
            try {
                System.out.printf("계산 결과 : %s\n", future.get());
            } catch(Exception e) {
                e.printStackTrace();
            }
        });
    }
}
