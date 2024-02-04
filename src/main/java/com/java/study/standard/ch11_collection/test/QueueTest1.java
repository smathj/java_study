package com.java.study.standard.ch11_collection.test;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTest1 {

    public static void main(String[] args) {

        System.out.println("========= offer Test ========");
        offsetTest();

        System.out.println();
        System.out.println();

        System.out.println("========= nullable하게 헤드값 읽기 Test ========");
        nullableQue();

        System.out.println();
        System.out.println();

        System.out.println("========= 예외가 발생하게 헤드값 읽기 Test ========");
        exceptionQue();



        System.out.println();
        System.out.println("=================================================");
        Queue<String> que = new LinkedList<>();
        que.offer("1");
        que.offer("2");
        que.offer("3");
        System.out.println("que = " + que);
        que.clear();
        System.out.println("que = " + que);

    }

    public static void offsetTest() {
        Queue<Object> que = new LinkedList<>();
        que.offer("1");
        que.offer(2);
        que.offer('A');

        System.out.println("que = " + que);

    }

    /**
     * nullable한 헤드 복사 및 추출
     * peek(복사) , poll(추출)
     */
    public static void nullableQue() {

        Queue<String> que = new LinkedList<>();

        que.offer("1");
        que.offer("2");
        System.out.println("큐 = " + que);


        // 비파괴적(비어있으면 null)
        System.out.println("[헤드의 값만 복사해 온다 peek()] = " + que.peek());
        System.out.println("[헤드의 값만 복사해 온다 peek()] = " + que.peek());


        // 파괴적(비어있으면 null)
        System.out.println("[헤드를 제거후 가져온다 poll()] = " + que.poll());
        System.out.println("[헤드를 제거후 가져온다 poll()] = " + que.poll());

    }


    /**
     * NoSuchElementException 예외가 발생하는 헤드 값 복사 및 추출
     * element(복사), remove(추출)
     */
    public static void exceptionQue() {
        try {
            Queue<String> que = new LinkedList<>();

            // 이 두줄을 주석하면 예외 발생
            que.offer("1");
//            que.offer("2");
            System.out.println("que = " + que);


            // 헤드의 값을 복사하기
            System.out.println("[헤드의 값만 복사해 온다 비어있으면 NoSuchElementException que.element()]= " + que.element());


            // 헤드 제거후 가져오기
            System.out.println("[헤드의 값만 복사해 온다 비어있으면 NoSuchElementException que.remove()] = " + que.remove());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
