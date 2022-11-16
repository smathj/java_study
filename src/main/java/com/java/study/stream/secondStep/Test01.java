package com.java.study.stream.secondStep;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Test01 {

    public static void main(String[] args) {

        List<Integer> myList = Arrays.asList(50, 10, 80, 70, 90, 60, 20);
        myList = new ArrayList<>(myList);

        System.out.print("점수 목록 : ");
        Stream<Integer> myStream = myList.stream();
        myStream.forEach((n) -> System.out.print(n + " "));
        System.out.println();

        // v1.
//        Optional<Integer> minVal = myList.stream().min((x, y) -> Integer.compare(x, y));

        // v2.
        Optional<Integer> minVal = myList.stream().min(Integer::compare);
        System.out.println("최저 점수 : " + minVal.get());

        Optional<Integer> maxVal = myList.stream().max(Integer::compare);
        System.out.println("최고 점수 : " + maxVal.get());

        System.out.print("점수 정렬 :");
        Stream<Integer> myStream2 = myList.stream().sorted();
        myStream2.forEach((n) -> System.out.print(n + " "));
        System.out.println();


        System.out.print("낙제 점수 : ");
        Stream<Integer> failScore = myList.stream().filter((n) -> n < 60).sorted();
        failScore.forEach((n) -> System.out.print(n + " "));
        System.out.println();


        System.out.print("점수 합계 : ");
        Optional<Integer> totalScore = myList.stream().reduce((a, b) -> a + b);
        System.out.println(totalScore.get());


        System.out.print("5점 추가 ");
        Stream<Integer> addScore = myList.stream().map((n) -> n + 5);
        addScore.forEach((n) -> System.out.print(n + " "));
        System.out.println();


        Long cnt = myList.stream().count();
        System.out.println("점수 개수 : " + cnt);

        System.out.println("점수 평균 : " + totalScore.get() / cnt);

    }
}
