package com.java.study.practical.ch6_parallel.part4_fork_join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class FutureExample {

    // Runnable은 리턴이 void
    // Callable은 리턴이 있다
    public Callable<Long> calSquare(long value) {
        Callable<Long> callable = new Callable<Long>() {
            @Override
            public Long call() throws Exception {
                Long returnValue = value * value;
                TimeUnit.SECONDS.sleep(1);
                System.out.println(value + " 의 제곱은근 " + returnValue);
                return returnValue;
            }
        };

        return callable;
    }

    public void executeTest() {
        List<Long> sampleDataList = Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L);

        ArrayList<Future<Long>> futureList = new ArrayList<>();

        // 스레드 풀을 생성한다, 고정 스레드 풀을 이용한다
        ExecutorService servicePool = Executors.newFixedThreadPool(4);

        // Callable 객체를 생성한 후 스레드 풀에 등록한다
        // 등록된 스레드에 대해 Future 객체를 리턴받는다
        for (Long sampleValue : sampleDataList) {
            Future<Long> future = servicePool.submit(calSquare(sampleValue));
            futureList.add(future);
        }

        Long sumValue = 0L;

        for (Future<Long> future : futureList) {
            try {
                // 결과를 읽어 들일 때까지 대기한다
                // 대기하는 동안, 스레드가 계산을 하고 값을 리턴한다
                sumValue += future.get();
            } catch(Exception e) {
                e.printStackTrace();
            }
        }

        System.out.println("최종 합계 : " + sumValue);

        servicePool.shutdown();

    }

    public static void main(String[] args) {
        FutureExample futureExample = new FutureExample();
        futureExample.executeTest();
    }

}
