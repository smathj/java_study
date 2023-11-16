package com.java.study.first.thread_pool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

public class Test10 {

    public static void main(String[] args) {

        ExecutorService threadPool = Executors.newCachedThreadPool();

        Future<Date> future = threadPool.submit(new Callable<Date>() {
            @Override
            public Date call() throws Exception {
                TimeUnit.SECONDS.sleep(1);
                return new Date();
            }
        });


        Date date = null;
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            date = future.get();    // 해당 스레드의 완료를 기다린다 ! await !
            System.out.println("date = " + date);
            String format = sdf.format(date);
            System.out.println("format = " + format);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
