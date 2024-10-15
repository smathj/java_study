package com.java.study.lamda.ch3.exception;

import java.util.function.Consumer;

public class Test1 {


    public static void runInSequence(Runnable first, Runnable second, Consumer<Throwable> exceptionHandler) {

        // 신규 스레드 생성
        new Thread(() -> {
            try {
                first.run();    // 하나의 작업 실행(순차)
                second.run();   // 하나의 작업 실행(순차)
            } catch(Exception e) {
                // exceptionHandler 를 정의해서 하면됨
                exceptionHandler.accept(e);
            }
        }).start();


    }

    public static void main(String[] args) {

        Consumer<Throwable> exceptionHandler = (Throwable) -> System.out.println("[에러 발생] 이메일 보냄 : " + Throwable.getMessage());
        Runnable first = () -> {
            System.out.println("첫번째 작업 시작");
            System.out.println("첫번째 작업 완료");
        };
        Runnable second = () -> {
            System.out.println("두번째 작업 시작");
            throw new RuntimeException("두번째 작업 에러가 발생");
        };

        runInSequence(first, second, exceptionHandler);
    }
}
