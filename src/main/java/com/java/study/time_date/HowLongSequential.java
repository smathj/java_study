package com.java.study.time_date;

import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class HowLongSequential {

    public static long fibonacci(long n) {
        // * 확인용
//        System.out.println("n = " + n);
//        return n;
        if (n == 1 || n == 2) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {

//        List<Integer> nums = Arrays.asList(40, 41, 42, 43, 44, 45);
        List<Integer> nums = Arrays.asList(1,2,3,4,5);

        // 스톱워치 시작
        Instant start = Instant.now();

        nums.stream()   // 순차 스트림 생성
                .map(n -> fibonacci(n))
                .forEach(r -> System.out.println("r = " + r));

        // 스톱워치 멈춤
        Instant end = Instant.now();

        System.out.println("Sequential Processing: " + Duration.between(start,end).toMillis());

    }
}
