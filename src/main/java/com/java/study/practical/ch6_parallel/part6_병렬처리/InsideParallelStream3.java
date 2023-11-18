package com.java.study.practical.ch6_parallel.part6_병렬처리;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.TimeUnit;

public class InsideParallelStream3 {

    public static void main(String[] args) throws Exception {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // 별도의 스레드 풀 생성
        ForkJoinPool customPool = new ForkJoinPool(2);
        ForkJoinTask<?> forkJoinTask = customPool.submit(() -> {

            // 스레드 풀 크기를 구한다
            System.out.printf("## Thread Pool Size : %s\n", customPool.getParallelism());

            // 스트림 내부의 스레드 값을 구한다
            intList.parallelStream().forEach((value) -> {
                // 현재 스레드 이름
                String threadName = Thread.currentThread().getName();

                // 스레드 이름과 데이터 값을 출력
                LocalDateTime currentTime = LocalDateTime.now();
                System.out.printf(currentTime.format(formatter) + " -> Thread Name : %s, System Value : %s\n", threadName, value);

                // 시간 확인을 위해 2초간 sleep
                try {
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });

        });

        forkJoinTask.get(); // Future 구현체

    }

}
