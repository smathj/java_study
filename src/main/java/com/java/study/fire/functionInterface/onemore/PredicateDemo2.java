package com.java.study.fire.functionInterface.onemore;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateDemo2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 5, 7, 9, 11, 12);


        for (Integer nowNum : list) {
            boolean roopResult = myTest((Integer param) -> {
                if (param % 2 == 0) {
                    System.out.println(param + "은 짝수 인것임");
                    return true;
                } else {
                    System.out.println(param + "은 홀수 인것임");
                    return false;
                }
            }, nowNum);
            System.out.println("roopResult = " + roopResult);
        }




    }

    private static boolean myTest(Predicate<Integer> myTest, Integer nowNum) {
        return myTest.test(nowNum);
    }
}
