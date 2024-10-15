package com.java.study.lamda.ch3.exception;

import lombok.AllArgsConstructor;
import lombok.Data;


/**
 * 체크드 예외를 언체크로 변환
 */
public class Test2_2 {


    @Data
    @AllArgsConstructor
    static class BankAccount {

        private String name;
        private int cash;

        /**
         * 체크 예외
         */
        public void debit(int amount) throws Exception {
            System.out.println(name + " " + + amount + "원 출금 되었습니다");
            cash = cash - amount;
        }


        /**
         * 체크 예외
         */
        public void credit(int amount) throws Exception {
            throw new RuntimeException("입금 에러발생");
//            System.out.println(name + " " + + amount + "원 입금 되었습니다");
//            cash =+ amount
        }
    }


    /**
     * 람다 내부에서 발생한 예외는 호출하는 곳으로 전파된다
     */
    public static void transfer(BankAccount a, BankAccount b, int amount) {

        Runnable debit = unchecked(() -> a.debit(amount));
        Runnable credit = unchecked(() -> b.credit(amount));

        try {
            // 람다식을 호출 하는 곳
            runInSequence(debit, credit);
        } catch(Exception e) {
            // 잔고를 검증하고 롤백
        }


    }

    /**
     * 체크드 예외를 언체크드 예외로 바꾸어 Runnable 생성
     */
    public static Runnable unchecked(Callable<Exception> function) {
        return () -> {
            try {
                function.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void runInSequence(Runnable first, Runnable second) throws Exception {


        // 신규 스레드 생성
        new Thread(() -> {
            System.out.println("신규 스레드 생성");
            first.run();    // 하나의 작업 실행(순차)
            second.run();   // 하나의 작업 실행(순차)
        }).start();

    }

    public static void main(String[] args) {

        BankAccount a = new BankAccount("A", 1000);
        BankAccount b = new BankAccount("B", 0);

        transfer(a, b, 1000);

    }






}
