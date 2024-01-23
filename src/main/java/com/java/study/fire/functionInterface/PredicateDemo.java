package com.java.study.fire.functionInterface;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo {

    /**
     * Predicate 파라미터를 제네릭으로 받아 boolean 타입을 리턴한다
     * @param p     람다식
     * @param lst   람다식이 사용할 데이터
     */
    public static int sum(Predicate<Integer> p, List<Integer> lst) {
        int s = 0;
        for (int n : lst) {
            if (p.test(n)) {
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


        // v2
        Predicate<List<Integer>> p1 = (intList) -> {
            int sum = 0;
            for (Integer i : intList) {
                sum += i;
            }
            return sum < 100;
        };

        boolean test1 = p1.test(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 100));
        System.out.println("test1 = " + test1);

        boolean test2 = p1.test(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        System.out.println("test2 = " + test2);

    }
}
