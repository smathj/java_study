package com.java.study.fire.functionInterface;


import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;

public class IntPredicateDemo {

    public static int sum(IntPredicate ip, List<Integer> lst) {
        int s = 0;
        for (int n : lst) {
            if (ip.test(n)) {   // 람다에 따른 짝,홀
                s += n;
            }
        }
        return s;
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 5, 7, 9, 11, 12);
        int s;
        s = sum(n -> n % 2 == 0, list);
        System.out.println("짝수 합 : " + s);

        s = sum(n -> n % 2 != 0, list);
        System.out.println("홀수 합 : " + s);
    }
}
