package com.java.study.fire.thread.thread03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class SyncArrayList {

    static List<Integer> lst = Collections.synchronizedList(new ArrayList<>());

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 16; i++) {
            lst.add(i);
        }
        System.out.println(lst);

        Runnable task = () -> {
            ListIterator<Integer> itr = lst.listIterator(); // 반복자 생성
            while (itr.hasNext()) {
                itr.set(itr.next() + 1);    // lst의 값을 1씩 증가
            }
        };

        ExecutorService exr = Executors.newFixedThreadPool(3);
        exr.submit(task);
        exr.submit(task);
        exr.submit(task);

        exr.shutdown();
        exr.awaitTermination(100, TimeUnit.SECONDS);
        System.out.println(lst);


    }
}
