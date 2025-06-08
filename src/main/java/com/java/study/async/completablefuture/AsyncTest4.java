package com.java.study.async.completablefuture;

import com.java.study.fire.nio.stream.DataFilterOutputStreamNewVer;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.function.Consumer;


/**
 * thenCombine 두개의 작업을 하나로 합치기
 */
public class AsyncTest4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        CompletableFuture<String> future1 = CompletableFuture.supplyAsync((() -> "작업1"));
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync((() -> "작업2"));


        // future1 -> future2
        // 각 리턴값을 다음 비동기에게 보낸다
        CompletableFuture<String> combine = future1.thenCombine(future2, (result1, result2) -> {
            System.out.println("result1 = " + result1);
            System.out.println("result2 = " + result2);
            return result1 + " + " + result2;
        });

        // combine.join() - RuntimeException 의 자손을 예외로 던짐
        // 결과를 캐싱한다, 불변성이 있기에 지울 순 없다, -> 새로운 객체 생성
        System.out.println(combine.join());

        System.out.println(combine.get());

        System.out.println(combine.join());
        System.out.println(combine.join());
        System.out.println(combine.join());
        System.out.println(combine.join());
        System.out.println(combine.join());
        System.out.println(combine.join());
        System.out.println(combine.join());
        System.out.println(combine.join());


    }

    public static void sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

