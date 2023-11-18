package com.java.study.practical.ch6_parallel.part9_원자적변수;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class ThreadLocalRandomExample {

    private int low;
    private int high;

    public ThreadLocalRandomExample(int low, int high) {
        this.low = low;
        this.high = high;
    }

    // JDK 7 ThreadLocalRandom 사용 방법
    public void generateRandom7() {
        System.out.println("## JAVA 7 방식");
        for (int i = 0; i < 100; i++) {
            System.out.println(ThreadLocalRandom.current().nextInt(low, high));
        }
    }

    // JDK 8 이상일 때 Stream을 이용한 ThreadLocalRandom 사용 방법
    public void generateRandom8() {
        System.out.println("## JAVA 8 방식");
        IntStream intStream = ThreadLocalRandom.current().ints(100, low, high);
        intStream.forEach((value -> System.out.println(value)));

    }

    public static void main(String[] args) {
        ThreadLocalRandomExample example = new ThreadLocalRandomExample(100, 1000);
        example.generateRandom7();
        example.generateRandom8();
    }
}
