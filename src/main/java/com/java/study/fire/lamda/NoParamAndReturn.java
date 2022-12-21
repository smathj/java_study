package com.java.study.fire.lamda;


import java.util.Random;

interface Generator {
    int rand(); // 매개변수 없는 메소드
}

public class NoParamAndReturn {
    public static void main(String[] args) {
        Generator gen = () -> {
            Random rand = new Random();
            return rand.nextInt(50); // 50 미만
        };

        int max = 0;
        for (int i = 0; i < 100; i++) {
            if (gen.rand() >= max) {
                max = gen.rand();
            }
        }
        System.out.println(max);
    }
}
