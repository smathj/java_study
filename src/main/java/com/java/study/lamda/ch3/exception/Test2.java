package com.java.study.lamda.ch3.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Test2 {


    @Data
    @AllArgsConstructor
    static class BankAccount {

        private String name;

        public void debit(int amount) throws Exception {
            System.out.println(name + " " + + amount + "원 출금 되었습니다");
        }

        public void credit(int amount) throws Exception {
            throw new RuntimeException("입금 에러발생");
//            System.out.println(name + " " + + amount + "원 입금 되었습니다");
        }
    }


    /**
     * 람다 내부에서 발생한 예외는 호출하는 곳으로 전파된다
     */
    public static void transfer(BankAccount a, BankAccount b, int amount) {

        Runnable debit = () -> {
            try {
                a.debit(amount);
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        };

        Runnable credit = () -> {
            try {
                b.credit(amount);
            } catch(Exception e) {
                throw new RuntimeException(e);
            }
        };

        // 람다식을 호출 하는 곳
        try {
            runInSequence(debit, credit);
        } catch(Exception e) {
            System.out.println("여기");
            e.printStackTrace();
        }

    }

    public static void runInSequence(Runnable first, Runnable second) {
        // 신규 스레드 생성
        new Thread(() -> {
            System.out.println("신규 스레드 생성");
            first.run();    // 하나의 작업 실행(순차)
            second.run();   // 하나의 작업 실행(순차)
        }).start();

    }

    public static void main(String[] args) {

        BankAccount a = new BankAccount("A");
        BankAccount b = new BankAccount("B");

        transfer(a, b, 100);
    }






}
