package com.java.study.practical.ch6_parallel.part9_원자적변수;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {

    private AtomicInteger c = new AtomicInteger();

    public void increment() {
        c.incrementAndGet();
    }

    public void decrement() {
        c.decrementAndGet();
    }

    public int value() {
        return c.get();
    }

    public static void main(String[] args) {
        AtomicCounter atomicCounter = new AtomicCounter();

        atomicCounter.increment();
        int v1 = atomicCounter.value();
        System.out.println("v1 = " + v1);

        atomicCounter.decrement();
        int v2 = atomicCounter.value();
        System.out.println("v2 = " + v2);

        AtomicInteger atomicInteger = new AtomicInteger(0);
        Integer a1 = atomicInteger.get();
        System.out.println("a1 = " + a1);
        atomicInteger.getAndAdd(1);
        Integer a2 = atomicInteger.get();
        System.out.println("a2 = " + a2);

    }
}
