package com.java.study.fire.thread.thread03;

import java.util.concurrent.*;

public class CallableDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> task = () -> {
            int sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += i;
            }
            return sum; // ! Return을 할 수 있따 !!
        };

        ExecutorService exr = Executors.newSingleThreadExecutor();
        Future<Integer> fur = exr.submit(task);

        Integer r = fur.get();  // 쓰레드 반환 값 획득
        System.out.println("result :" + r);
        exr.shutdown();
    }
}
