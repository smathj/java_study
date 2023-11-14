package com.java.study.practical.ch6_parallel.part4_fork_join;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class DelayedTaskExample {

    public static void main(String[] args) {

        ScheduledExecutorService exeService = Executors.newSingleThreadScheduledExecutor();

        // 스레드 3개 등록과 실행
        exeService.schedule(() -> System.out.println("스케줄러 TODO 1"), 10, TimeUnit.SECONDS);
        exeService.schedule(() -> System.out.println("스케줄러 TODO 2"), 20, TimeUnit.SECONDS);
        exeService.schedule(() -> System.out.println("스케줄러 TODO 3"), 30, TimeUnit.SECONDS);
        // Callable 은 리턴타입이있네




    }
}
