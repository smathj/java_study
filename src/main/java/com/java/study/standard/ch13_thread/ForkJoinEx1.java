package com.java.study.standard.ch13_thread;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinEx1 {

    static final ForkJoinPool pool = new ForkJoinPool();    // 쓰레드 풀
    public static void main(String[] args) {

        long from = 1L, to = 100_000_000L;

        SumTask task = new SumTask(from, to);

        long start = System.currentTimeMillis();    // 시작 시간 초기화
        Long result = pool.invoke(task);
        System.out.println(System.currentTimeMillis() - start);

        System.out.printf("[6코어] sum of %d~%d=%d%n", from, to, result);
        System.out.println();

        result = 0L;
        start = System.currentTimeMillis(); // 시작 시간 초기화
        for (long i = from; i <= to; i++) {
            result += i;
        }

        System.out.println(System.currentTimeMillis() - start);
        System.out.printf("[1코어] sum of %d~%d=%d%n", from, to, result);
        System.out.println();


    }

    static class SumTask extends RecursiveTask<Long> {

        long from, to;

        public SumTask(long from, long to) {
            this.from = from;
            this.to = to;
        }


        @Override
        protected Long compute() {
            long size = to - from + 1;  // from <= i <= to

            if (size <= 5) {    // 더할 숫자가 5개 이하면
                return sum();
            }

            long half = (from + to) / 2;

            // 범위를 반으로 나눠서 두 개의 작업을 생성
            SumTask leftSum = new SumTask(from, half);
            SumTask rightSum = new SumTask(half + 1, to);

            leftSum.fork(); // 큐에 넣는다

            // 다른 한쪽 재귀 실행, 남은 한쪽은 동기로서 결과 대기하여 누적
            return rightSum.compute() + leftSum.join();

        }

        public long sum() {
            long tmp = 0L;

            for (long i = from; i <= to; i++) {
                tmp += i;
            }

            return tmp;
        }
    }
}
